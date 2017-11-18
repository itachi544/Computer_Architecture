package load;
import java.io.BufferedWriter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class LoadStore {
	static int cpuintensive=0;
	static int memintensive=0;
	static ArrayList<String> inputfile=new ArrayList<String>();
	static ArrayList<String> outputfile=new ArrayList<String>();
	static ArrayList<String> Code=new ArrayList<String>();
	public static void main(String[] args) 

	{
		Scanner scanner;
		try 
			{
				scanner = new Scanner(new FileReader("7.txt"));
				while(scanner.hasNextLine())
				{
					Code.add(scanner.nextLine());
				}
			} 
		    catch (FileNotFoundException e) 
		    {
				
				e.printStackTrace();
			}
		    String currentLine;
			for(int i=0;i<Code.size();i++)
			{
				String currentline=Code.get(i);
				if(currentline.contains(";"))
				{
					currentLine=currentline.replace(";","");
					inputfile.add("\n");
					inputfile.add(currentLine);
				}
				else
				{
					inputfile.add("\n");
					inputfile.add(currentline);
				}
			}
			System.out.println("\n-----------------------------------------INPUT AND RESULTING OUTPUT---------------------------------------------\n\n");
			System.out.println("\n-----------------------------------------1.INPUT(C like instructions)---------------------------------------------");
			for(int i=0;i<inputfile.size();i++)
			{
				currentLine=inputfile.get(i);
				System.out.println(inputfile.get(i));
				if(currentLine.contains("While"))
				{
					WhileCase(currentLine);
				}
				else
				if(currentLine.contains("Loop:"))
				{
					LoopCase(currentLine);
				}
				else
				if(currentLine.contains("If") && currentLine.contains("Goto"))
				{
					IfGoto(currentLine);
				}
				else
				if(currentLine.contains("If") && !currentLine.contains("Goto"))
				{
					IfCode(currentLine);
				}
				else
				if(currentLine.contains("Else"))
				{
					ElseCase(currentLine);
				}
				else
				if(currentLine.length()==9)
				{
					String breakline[]=currentLine.split(" ");
					outputfile.add("\nLoad R1, "+breakline[2]);
					outputfile.add("\nLoad R2, "+breakline[4].charAt(0));
					if(breakline[4].charAt(0)=='+')
					{
						outputfile.add("\nAdd R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='-')
					{
						outputfile.add("\nSub R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='*')
					{
						outputfile.add("\nMul R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='/')
					{
						outputfile.add("\nDiv R3, R2, R1");
					}
					outputfile.add("\nStore "+breakline[0]+", R3");
				}
				else
				if(currentLine.length()==19)
				{
					String breakline[]=currentLine.split(" ");
					outputfile.add("\nLoad R1, "+breakline[2].charAt(1));
					outputfile.add("\nLoad R2, "+breakline[4].charAt(0));
					if(breakline[4].charAt(0)=='+')
					{
						outputfile.add("\nAdd R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='-')
					{
						outputfile.add("\nSub R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='*')
					{
						outputfile.add("\nMul R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='/')
					{
						outputfile.add("\nDiv R3, R2, R1");
					}
					System.out.println();
					if(breakline[5].charAt(0)=='+')
					{
						outputfile.add("\nLoad R1, "+breakline[6]);
						outputfile.add("\nAdd R3, R3, R1");
					}
					else
					if(breakline[5].charAt(0)=='-')
					{
						outputfile.add("\nLoad R1, "+breakline[6]);
						outputfile.add("\nSub R3, R3, R1");
					}
					else
					if(breakline[5].charAt(0)=='*')
					{
						outputfile.add("\nLoad R1, "+breakline[6]);
						outputfile.add("\nMul R3, R3, R1");
					}
					else
					if(breakline[5].charAt(0)=='/')
					{
						outputfile.add("\nLoad R1, "+breakline[6]);
						outputfile.add("\nDiv R3, R3, R1");
					}
					System.out.println();
					if(breakline[7].charAt(0)=='+')
					{
						outputfile.add("\nLoad R1, "+breakline[8]);
						outputfile.add("\nAdd R3, R3, R1");
					}
					else
					if(breakline[7].charAt(0)=='-')
					{
						outputfile.add("\nLoad R1, "+breakline[8]);
						outputfile.add("\nSub R3, R3, R1");
					}
					else
					if(breakline[7].charAt(0)=='*')
					{
						outputfile.add("\nLoad R1, "+breakline[8]);
						outputfile.add("\nMul R3, R3, R1");
					}
					else
					if(breakline[7].charAt(0)=='/')
					{
						outputfile.add("\nLoad R1, "+breakline[6]);
						outputfile.add("\nDiv R3, R3, R1");
					}
					outputfile.add("\nStore "+breakline[0]+", "+"R3");
				}
				else
				if(currentLine.length()==21)
				{
					String breakline[]=currentLine.split(" ");
					outputfile.add("\nLoad R1, "+breakline[2].charAt(1));
					outputfile.add("\nLoad R2, "+breakline[4].charAt(0));
					if(breakline[4].charAt(0)=='+')
					{
						outputfile.add("\nAdd R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='-')
					{
						outputfile.add("\nSub R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='*')
					{
						outputfile.add("\nMul R3, R2, R1");
					}
					else
					if(breakline[4].charAt(0)=='/')
					{
						outputfile.add("\nDiv R3, R2, R1");
					}
					System.out.println();
					outputfile.add("\nLoad R4, I");
					outputfile.add("\nLoad R5, J");
					outputfile.add("\nADD R6, R4, R5");
					outputfile.add("\nSub R7, R3, R6");
					outputfile.add("\nStore F, R7");
				}
			}
			int codeSize=0;
			int dataSize=0;
			System.out.println("\n------------------------------------------2.OUTPUT(Resulting MIPS like Assembly Code)-------------------------------");
			for(int i=0;i<outputfile.size();i++)
			{
				System.out.println(outputfile.get(i));
			}
			System.out.println("\n\n-------------------------------------------------------------------");
			System.out.println("The Total number of Instructions are "+outputfile.size());
			outputfile.add("\n\n-------------------------------------------------------------------");
			outputfile.add("\n\nThe Total number of Instructions are "+outputfile.size());
			int MemoryCounter=0;
			for(int i=0;i<outputfile.size();i++)
			{
				if(outputfile.get(i).contains(""))
				{
					MemoryCounter++;
				}
			}
			
			System.out.println("\nThe Total number of memory accesses "+MemoryCounter);
			outputfile.add("\nThe Total memory accesses is "+MemoryCounter);

			for(int i=0;i<outputfile.size();i++)
			{
				String line=outputfile.get(i);
				String breakline[]=line.split(" ");
				for(int j=0;j<breakline.length;j++)
				{
					if(breakline[j].trim().length()==1)
					{
						codeSize=codeSize+3;
					}
					else
					if(breakline[j].trim().length()==2)
					{
						codeSize=codeSize+1;
					}
				}
			}
			
			
			
			System.out.println("\nSize of the resulting machine code in bytes "+codeSize);
			outputfile.add("\nSize of the resulting machine code in bytes"+codeSize);
			
			for(int i=0;i<outputfile.size();i++)
			{
				if(outputfile.get(i).contains("ADD") || outputfile.get(i).contains("SUB") || outputfile.get(i).contains("MUL") || outputfile.get(i).contains("DIV") ||outputfile.get(i).contains("BEQ") || outputfile.get(i).contains("BNE"))
				{
					cpuintensive++;
				}
				else
				if(outputfile.get(i).contains("Load") || outputfile.get(i).contains("Store"))
				{
					memintensive++;
					dataSize=dataSize+1;
				}
			}
			System.out.println("\nData Size in Bytes "+dataSize);
			outputfile.add("\nData Size in Bytes "+dataSize);
			int memorybandwidth=codeSize+dataSize;
			System.out.println("\nTotal Memory Bandwidth in Bytes:" +memorybandwidth);
			outputfile.add("\nTotal Memory Bandwidth in Bytes:" +memorybandwidth);
			int k=(cpuintensive-memintensive);
			int j=(memintensive-cpuintensive);
			if(k>=(cpuintensive+memintensive)*0.9)
			{
				System.out.println("\nThis is a CPU access intensive program");
				outputfile.add("\nThis is a CPU access intensive program");
			}
			else
			if(j>=(cpuintensive+memintensive)*0.9)
			{
				System.out.println("\nThis is a Memory access intensive program");
				outputfile.add("\nThis is a Memory access intensive program");
			}
			else
			{
				System.out.println("\nThis is a Balanced program");
				outputfile.add("\nThis is a Balanced program");
			}
			
	
			try {

				
				File file = new File("output_file.txt");
				if (file.exists()) {
					file.delete();
				}
				FileWriter fileWriter = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fileWriter);
				bw.write("\n-----------------------------------------INPUT AND RESULTING OUTPUT---------------------------------------------\n\n");
				bw.write("\n-----------------------------------------1.INPUT(C like instructions)---------------------------------------------");
				for(int i=0;i<inputfile.size();i++)
				bw.write(LoadStore.inputfile.get(i));
				bw.write("\n------------------------------------------2.OUTPUT(Resulting MIPS like Assembly Code)-------------------------------");
				for(int i=0;i<outputfile.size();i++)
				bw.write(LoadStore.outputfile.get(i));
				bw.close();
				} catch (Exception e) {

				}
	}
	
	
	

	private static void ElseCase(String currentLine) 
	{
		
		String breakline[]=currentLine.split(" ");
		if(breakline[4].charAt(0)=='+')
		{
			outputfile.add("\nLoad R1, "+breakline[3]);
			outputfile.add("\nLoad R2, "+breakline[5]);
			outputfile.add("\nAdd R3, R2, R1");
		}
		else
		if(breakline[4].charAt(0)=='-')
		{
			outputfile.add("\nLoad R1, "+breakline[3]);
			outputfile.add("\nLoad R2, "+breakline[5]);
			
			outputfile.add("\nSub R3, R2, R1");
		}
		else
		if(breakline[4].charAt(0)=='*')
		{
			outputfile.add("\nLoad R1, "+breakline[3]);
			outputfile.add("\nLoad R2, "+breakline[5]);
			outputfile.add("\nMul R3, R2, R1");
		}
		else
		if(breakline[4].charAt(0)=='/')
		{
			outputfile.add("\nLoad R1, "+breakline[3]);
			outputfile.add("\nLoad R2, "+breakline[5]);
			outputfile.add("\nDiv R3, R2, R1");
		}
		outputfile.add("\nStore "+breakline[1]+", R3");
	}
	private static void IfCode(String currentLine) 
	{
		
		String breakline[]=currentLine.split(" ");
		outputfile.add("\nLoad R1, "+breakline[1].charAt(1));
		outputfile.add("\nLoad R2, "+breakline[3].charAt(0));
		if(breakline[2].charAt(0)=='=')
		{
			outputfile.add("\nBEQ R2, R1, NEXTi");
		}
		else
		if(breakline[2].charAt(0)=='!')
		{
				outputfile.add("\nBNEQ R2, R1, NEXTi");
		}
		outputfile.add("NEXTi:");
		if(breakline[7].charAt(0)=='+')
		{
			outputfile.add("\nLoad R1, "+breakline[6]);
			outputfile.add("\nLoad R2, "+breakline[8]);
			outputfile.add("\nAdd R3, R2, R1");
		}
		else
		if(breakline[7].charAt(0)=='-')
		{
			outputfile.add("\nLoad R1, "+breakline[6]);
			outputfile.add("\nLoad R2, "+breakline[8]);
			outputfile.add("\nSub R3, R2, R1");
		}
		else
		if(breakline[7].charAt(0)=='*')
		{
			outputfile.add("\nLoad R1, "+breakline[6]);
			outputfile.add("\nLoad R2, "+breakline[8]);
			outputfile.add("\nMul R3, R2, R1");
		}
		else
		if(breakline[7].charAt(0)=='/')
		{
			outputfile.add("\nLoad R1, "+breakline[6]);
			outputfile.add("\nLoad R2, "+breakline[8]);
			outputfile.add("\nDiv R3, R2, R1");
		}
		outputfile.add("\nStore "+breakline[4]+", R3");
		
		
	}
	private static void IfGoto(String currentLine) 
	{
		
		String breakline[]=currentLine.split(" ");
		outputfile.add("\nLoad R1, "+breakline[1].charAt(1));
		outputfile.add("\nLoad R2, "+breakline[3].charAt(0));
		if(breakline[2].charAt(0)=='=')
		{
			outputfile.add("\nBEQ R2, R1, "+breakline[5]);
		}
		if(breakline[2].charAt(0)=='!')
		{
			outputfile.add("\nBNEQ R2, R1, "+breakline[5]);
		}
		if(breakline[2].charAt(0)=='<')
		{
			outputfile.add("\nBLT R2, R1, "+breakline[5]);
		}
		if(breakline[2].charAt(0)=='>')
		{
			outputfile.add("\nBGT R2, R1, "+breakline[5]);
		}
		
	}
	private static void LoopCase(String currentLine) 
	{
		outputfile.add("\nLoop:");
		String breakline[]=currentLine.split(" ");
		outputfile.add("\nLoad R1, "+breakline[5].charAt(2));
		outputfile.add("\nMul R2, R1,"+4);
		outputfile.add("\nAdd R3, R2, "+breakline[5].charAt(0));
		outputfile.add("\nAdd R4, R3, R2");
		outputfile.add("\nStore "+breakline[1]+", "+"R4");
	}
	private static void WhileCase(String currentLine) 
	{
		String breakline[]=currentLine.split(" ");
		outputfile.add("\nLoop1:");
		outputfile.add("\nLoad R1, "+breakline[1].charAt(6));
		outputfile.add("\nAdd R2, R1, "+breakline[1].charAt(6));
		outputfile.add("\nAdd R3, R2, "+breakline[1].charAt(6));
		outputfile.add("\nAdd R4, R3, "+breakline[1].charAt(6));
		outputfile.add("\nAdd R5, R4,  "+breakline[1].charAt(6));
		outputfile.add("\nAdd R6, R5,  "+breakline[1].charAt(1));
		outputfile.add("\nStore "+breakline[3].charAt(0)+","+"R6");
		
	}
}

