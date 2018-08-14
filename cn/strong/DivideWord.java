package cn.strong;

import java.io.*;
import java.util.*;

public class DivideWord {
	public String left_to_right_divide(String sentence,int max) throws IOException{
		List words=new ArrayList();	//���ڴ�Ŵʵļ���
		int i=0;
		String word="";
		int maxnum=max;	//����max��ֵ
		while(i<sentence.length()){
			//��ȡmax���ȵĴʣ����ܳ��Ȳ��㣬���ȡʣ�ಿ��
			if(i+max<=sentence.length()){
				word=sentence.substring(i,i+max);
			}else{
				word=sentence.substring(i);
			}
			//�����ȡ��word�Ǹ��ʻ��ߵ�ǰmaxֵΪ1����word���뵽�ʼ����У�����ָ����ǰ�ƶ�i��λ
			if(isWord(word)||max==1){
				words.add(word);
				i=i+max;
				max=maxnum;
			}else{
				max--;
			}
		}
		//�����Ϻϳ�һ���ַ�������
		String result="";
		for(int j=0;j<words.size();j++){
			result+=words.get(j).toString()+"/";
		}
		return result;
	}
	
	public String right_to_left_divide(String sentence,int max) throws IOException{
		List words=new ArrayList();	//���ڴ�Ŵʵļ���
		int i=sentence.length();
		String word="";
		int maxnum=max;	//����max��ֵ
		while(i>0){
			//��ȡmax���ȵĴʣ����ܳ��Ȳ��㣬���ȡʣ�ಿ��
			if(i-max>=0){
				word=sentence.substring(i-max,i);
			}else{
				word=sentence.substring(0,i);
			}
			
			//�����ȡ��word�Ǹ��ʻ��ߵ�ǰmaxֵΪ1����word���뵽�ʼ����У�����ָ����ǰ�ƶ�i��λ
			if(isWord(word)||max==1){
				words.add(word);
				i=i-max;
				max=maxnum;
			}else{
				max--;
			}
		}
		//�����Ϻϳ�һ���ַ�������
		String result="";
		for(int j=words.size()-1;j>=0;j--){
			result+=words.get(j).toString()+"/";
		}
		return result;
	}
	
	//�򿪴ʵ�word.txt��ƥ��word���ж�word�Ƿ���һ����
	public boolean isWord(String word) throws IOException{
		boolean isword=false;
		BufferedReader br=new BufferedReader(new FileReader("D:\\jdk\\java\\SpiltWords\\dictionary.txt"));
		String text;
		while((text=br.readLine())!=null){
			String[]key=text.split(",");
//			System.out.println(key[0]);
			if(word.equals(key[0])) {
				isword=true;
			}
		}
		br.close();
		return isword;
	}
	
	public static void main(String[]args) throws IOException{
		
	}
}

