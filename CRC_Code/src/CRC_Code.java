import java.io.*;
class CRC_Code
{
    public static void main(String args[]) throws IOException
    {
    	
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] data; int[] div;
        int[] remainder; int[] crc; int[] divisor;

        int data_bits, divisor_bits, tot_length;
       
        System.out.println("Cik bitus saturçs dati : ");
        data_bits=Integer.parseInt(br.readLine());
        data=new int[data_bits];

        System.out.println("Ievadiet datu bitus (pa vienam) : ");
        for(int i=0; i<data_bits; i++)
            data[i]=Integer.parseInt(br.readLine());

        System.out.println("Cik bitu bûs dalîtâjâ: ");
        divisor_bits=Integer.parseInt(br.readLine());
        divisor=new int[divisor_bits];
       
        System.out.println("Ievadiet dalîtâja bitus (pa vienam) : ");
        for(int i=0; i<divisor_bits; i++)
            divisor[i]=Integer.parseInt(br.readLine());


        System.out.print("Datu biti ir: ");
        for(int i=0; i< data_bits; i++)
            System.out.print(data[i]);       
        System.out.println();
       
        System.out.print("Dalîtâja biti: ");
        for(int i=0; i< divisor_bits; i++)
            System.out.print(divisor[i]);       
        System.out.println();
       
        tot_length=data_bits+divisor_bits-1;
       
        div=new int[tot_length];
        remainder=new int[tot_length];
        crc=new int[tot_length];
        
        
        for(int i=0;i<data.length;i++)
            div[i]=data[i];
       
        System.out.print("Dalîtâjs papildinats ar nullçm : ");
        for(int i=0; i< div.length; i++)
            System.out.print(div[i]);       
        System.out.println();
       
        for(int j=0; j<div.length; j++){
              remainder[j] = div[j];
        }
   
        remainder=divide(div, divisor, remainder);
       
        for(int i=0;i<div.length;i++)         
        {
            crc[i]=(div[i]^remainder[i]);
        }
       
        System.out.println();
        System.out.println("CRC kods ir : ");   
        for(int i=0;i<crc.length;i++)
            System.out.print(crc[i]);
           

        System.out.println();
        System.out.println("Ievadiet saòemto kodu "+tot_length+" bitu garumâ : ");
        for(int i=0; i<crc.length; i++)
            crc[i]=Integer.parseInt(br.readLine());
            
        for(int j=0; j<crc.length; j++){
              remainder[j] = crc[j];
        }
   
        remainder=divide(crc, divisor, remainder);
       
        for(int i=0; i< remainder.length; i++)
        {
            if(remainder[i]!=0)
            {
                System.out.println("Saòemtajos datos ir kïûda");
                break;
            }
            if(i==remainder.length-1)
                System.out.println("Saòemtajos datos nav kïûdu");
        }

    }
   
    static int[] divide(int div[],int divisor[], int remainder[])
    {
        int cur=0;
        while(true)
        {
            for(int i=0;i<divisor.length;i++)
                remainder[cur+i]=(remainder[cur+i]^divisor[i]);
           
            while(remainder[cur]==0 && cur!=remainder.length-1)
                cur++;
   
            if((remainder.length-cur)<divisor.length)
                break;
        }
        return remainder;
    }
}