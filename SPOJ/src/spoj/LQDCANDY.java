package spoj;

import java.io.IOException;
import java.io.PrintWriter;

class LQDCANDY {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Reader sc = new Reader();
		PrintWriter pw = new PrintWriter(System.out, true);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			// Take Input here
			long n2 = sc.nextLong();
			//Find nearest 2 power
			long n=n2;
			n--;
			n |= n >> 1;
			n |= n >> 2;
			n |= n >> 4;
			n |= n >> 8;
			n |= n >> 16;
			n |= n >> 32;
			n++;
			//Find most signifcant 1
			 long v=n2;     // 32-bit word input to count zero bits on right
			int c;     // c will be the number of zero bits on the right,
			                    // so if v is 1101000 (base 2), then c will be 3
			// NOTE: if 0 == v, then c = 31.
			if ((v & 0x1)>0) 
			{
			  // special case for odd v (assumed to happen half of the time)
			  c = 0;
			}
			else
			{
			  c = 1;
			  if ((v & 0xffffff) == 0) 
			  {  
			    v >>= 32;  
			    c += 32;
			  }
			  if ((v & 0xffff) == 0) 
			  {  
			    v >>= 16;  
			    c += 16;
			  }
			  if ((v & 0xff) == 0) 
			  {  
			    v >>= 8;  
			    c += 8;
			  }
			  if ((v & 0xf) == 0) 
			  {  
			    v >>= 4;
			    c += 4;
			  }
			  if ((v & 0x3) == 0) 
			  {  
			    v >>= 2;
			    c += 2;
			  }
			  c -= v & 0x1;
			}	
			// Find least significant 1
			long v2=n2;  // 32-bit value to find the log2 of 
			long b[] = {0x2, 0xC, 0xF0, 0xFF00, 0xFFFF0000, 0xFFFFFFFF00000000L};
			int S[] = {1, 2, 4, 8, 16, 32};
			

			 int r = 0; // result of log2(v) will go here
			for (int j = 5; j >= 0; j--) // unroll for speed...
			{
			  if ((v2 & b[j])!=0)
			  {
			    v2 >>= S[j];
			    r |= S[j];
			  } 
			}
			int count=r-c+1;
			if((n2&(n2-1))==0) count--;
			pw.println(n+" "+count);
			
		}
		sc.close();
	}

}


