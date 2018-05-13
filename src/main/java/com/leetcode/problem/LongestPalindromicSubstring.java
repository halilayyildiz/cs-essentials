package com.leetcode.problem;

public class LongestPalindromicSubstring
{

	public String longestPalindrome(String s)
	{
		final long startTime = System.currentTimeMillis();
		
		StringBuffer result = new StringBuffer();
		StringBuffer temp = new StringBuffer();
		StringBuffer temp2 = new StringBuffer();
		
		char[] input = s.toCharArray();
		if(input.length > 0)
		{
			result.append(input[0]);
		}
		
		for (int i = 0; i < input.length; i++)
		{
			temp = new StringBuffer();
			temp2 = new StringBuffer();
			
			boolean contExec1 = true;
			boolean contExec2 = true;
			for (int j = 1; true; j++)
			{
				boolean contExec = false;
				
				if((i-j) >=0 && i+j < input.length && input[i-j] == input[i+j] && contExec1)
				{
					if(j == 1)
					{
						temp = new StringBuffer().append(input[i]);
					}
					
					temp = new StringBuffer().append(input[i-j]).append(temp).append(input[i+j]);
					if(temp.length() > result.length())
					{
						result = temp;
					}
					contExec = true;
				}
				else
				{
					contExec1 = false;
				}
				
				if((i-j+1) >=0 && i+j < input.length && input[i-j+1] == input[i+j] && contExec2)
				{
					temp2 = new StringBuffer().append(input[i-j+1]).append(temp2).append(input[i+j]);
					if(temp2.length() > result.length())
					{
						result = temp2;
					}
					contExec = true;
				}
				else
				{
					contExec2 = false;
				}
				
				if(!contExec)
				{
					break;
				}
				
			}
		}
		
		final long duration = System.currentTimeMillis() - startTime;
		System.out.println((double)duration/1000);
		System.out.println(result.toString());
		
		
		return result.toString();
	}

	public static void main(String[] args)
	{
//		new LongestPalindromicSubstring().longestPalindrome("daomdukomcayjwgmmetypncdeixarhbectjcwftjjtwjrctixtrsehegwlfotpljeeqhntacfihecdjysgfmxxbjfeskvvfqdoedfxriujnoeteleftsjgdsagqvcgcdjbxgmguunhbjxyajutohgbdwqtjghdftpvidkbftqbpeahxbfyamonazvubzirhqseetaneptnpjbtrtitttxsyjckjvwtrmuwgidkofvobrwrffzrpnxbectsydbvswstfiqranjzhsebjnmprjoirqkgttahrivkcjtitdcpohwwerwgrdivqbltfnigavydxpmitttjjzyrmpaptkczzgnsovebvxezkkovgqegctxacvjfqwtiycnhartzczcgosiquhmdbljjzyrnmffcwnkyzytnsvyzayrieqyrfpxintbbiyrawxlguzaisedwabpzvevlejadztuclcpwvonehkhknicdksdcnjfaoeaqhcdkdtywilwewadcnaprcasccdcnvdgjdqirrsqwzhqqorlhbgpelpupdvuynzybcqkffnnpocidkkigimsa");
		new LongestPalindromicSubstring().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

	}

}
