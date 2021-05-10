import java.util.*;
import java.io.*;
class GamingBoard
{
	static HashSet<Integer> ur=new HashSet<Integer>();
	static HashSet<Integer> cr=new HashSet<Integer>();
	static void board_print(char[][] print)
	{
		for(int i=0;i<print.length;i++)
		{
			for(int j=0;j<print[0].length;j++)
			{
				System.out.print(print[i][j]);
			}
			System.out.println();
		}
	}
		static void place(char[][] print,String user,int pos)
		{
			char sym='X';
			if(user.equals("You"))
			{
				sym='X';
				ur.add(pos);
			}
			else if(user.equals("Com"))
			{
				sym='O';
				cr.add(pos);
			}
			switch(pos)
			{
				case 1:print[0][0]=sym;
				break;
				case 2:print[0][2]=sym;
				break;
				case 3:print[0][4]=sym;
				break;
				case 4:print[2][0]=sym;
				break;
				case 5:print[2][2]=sym;
				break;
				case 6:print[2][4]=sym;
				break;
				case 7:print[4][0]=sym;
				break;
				case 8:print[4][2]=sym;
				break;
				case 9:print[4][4]=sym;
				break;
				default:
				System.out.print("PLEASE ENTER THE NUMBERS BETWEEN 1 TO 9");
			}
			board_print(print);
		}
		static int	generate_number()
	{
		int a=(int)Math.floor(Math.random()*10)+1; 
		return a;
	}
	static String chech_method()
	{
		HashSet<Integer> r1=new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2=new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3=new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer> c1=new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		HashSet<Integer> c2=new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		HashSet<Integer> c3=new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		HashSet<Integer> d1=new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer> d2=new HashSet<Integer>();
		d2.add(3);d2.add(5);d2.add(7);
		
		HashSet<HashSet> set=new HashSet<HashSet>();
		set.add(r1);set.add(r2);set.add(r3);
		set.add(c1);set.add(c2);set.add(c3);
		set.add(d1);set.add(d2);
		
		for(HashSet c:set)
		{
			if(ur.containsAll(c))
				return "TOU WIN";
			else if(cr.containsAll(c))
				return "TOU LOSS";
		}
			 if(ur.size()+cr.size()==9)
				return "DRAW";
		
				return "";
	}
	
	public static void main(String args[])
	{
		
		
		char[][] print={
			{' ','|',' ','|',' '},
			
			{'-','|','-','|','-'},
			
			{' ','|',' ','|',' '},
			
			{'-','|','-','|','-'},

			{' ','|',' ','|',' '}
		};
		board_print(print);
					System.out.println("========================");
					Scanner sc=new Scanner(System.in);

		while(true)
		{
					System.out.print("ENTER THE NUMBERS FROM 1-9 ");
						int user_input=sc.nextInt();
						while(ur.contains(user_input)||cr.contains(user_input))
						{
							//System.out.println();
							System.out.print("THE ENTERED POSITION IS ALREAADY FILEED :ENTER THE NUMBERS FROM 1-9 ");
						     user_input=sc.nextInt();
						}
						         place(print,"You",user_input);
								 String res=chech_method();
								 if(res.length()>0)
								 {
									 System.out.print("YOU HAVE WON THE GAME");
									 break;
								 }
								 	System.out.println("========================");
								
								int cop_input=generate_number();
								while(ur.contains(cop_input)|cr.contains(cop_input))
								{
									cop_input=generate_number();
								}
								place(print,"Com",cop_input);
								res=chech_method();
								if(res.length()>0)
								 {
									 System.out.print("YOU HAVE LOSS THE GAME");
									 break;
								 }
		}
	
		

	}
}