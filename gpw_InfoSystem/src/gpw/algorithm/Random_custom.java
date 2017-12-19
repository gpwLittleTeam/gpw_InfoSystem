package gpw.algorithm;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Random_custom
{
	/**
	 * 返回一个随机数，随机范围[start,end]
	 * @param start 可随机到的最小值，闭区间
	 * @param end 可随机到的最大值，闭区间
	 * @return 随机数
	 */
	public int random(int start, int end)
	{
		Calendar calendar = Calendar.getInstance();
		int result;
		int boundSize = end - start + 1;
		int seconds = calendar.get(Calendar.SECOND); //获得秒数
		//System.out.println("seconds: " + seconds);
		long seed = System.nanoTime() >> 2;
		seed = (seed % 96041521) * seconds;
				
	//	System.out.println("System.nanoTime: "  + seed);
		Random r = new Random(seed); // 
		result = r.nextInt(boundSize);
		if (start < end)
		{ // 处理end<start的情况
			result += start;
		}
		else
		{
			result += end;
		}
		return result;
	}
	
	/**
	 * 返回一个随机数数组，可出现重复数，随机范围[start,end]
	 * @param start 可随机到的最小值，闭区间
	 * @param end 可随机到的最大值，闭区间
	 * @param arraySize 数组的大小
	 * @return 随机数组
	 */
	public int[] randoms(int start, int end, int arraySize)
	{
		int[] aNo = new int[arraySize];

		for (int i = 0; i < arraySize; i++)
		{
			aNo[i] = random(start, end);
		}
		return aNo;
	}

	//arraySize 要抽的随机数的个数
	private void randomsNoRepeat(int start, int end, int arraySize, HashSet set){
		int size = set.size(); //当前set的个数
		Integer inte;
		while(set.size() < (arraySize+size))
		{
			inte = new Integer(random(start, end));
			set.add(inte);
		} 
	}
	
	/**
	 * 返回一个随机数数组，无重复数，随机范围[start,end]
	 * @param start 可随机到的最小值，闭区间
	 * @param end 可随机到的最大值，闭区间
	 * @param arraySize 数组的大小
	 * @return 随机数组
	 */
	public int[] randomsNoRepeat(int start,int end,int number) {
		int[] result = new int[number];
		HashSet set = new HashSet();
		randomsNoRepeat(start, end, number, set);
		Iterator iter = set.iterator();
		int count = 0;
		while(iter.hasNext()){
			//System.out.println(iter.next());
			result[count] = ((Integer)iter.next()).intValue();
			count++;
		}
		insertSort(result);
		return result;
	}
	
	//插入排序
	public void insertSort(int[] arr)
	{
	    int i, j;
	    int n = arr.length;
	    int target;
	 
	    //假定第一个元素被放到了正确的位置上
	    //这样，仅需遍历1 - n-1
	    for (i = 1; i < n; i++)
	    {
	        j = i;
	        target = arr[i];
	 
	        while (j > 0 && target < arr[j - 1])
	        {
	            arr[j] = arr[j - 1];
	            j--;
	        }
	 
	        arr[j] = target;
	    }
	}
	
	/*
	public static void main(String[] args)
	{
		Random_custom obj = new Random_custom();
		
		//randoms(int , int , int ) 测试
		int arraySize = 10000;
		int[] arr = new int[arraySize];
		int[] count = new int[5];
		for (int j = 0; j < 5; j++)
		{
			count[j] = 0;
		}
		arr = obj.randoms(5, 9, arraySize);
		for (int i = 0; i < arraySize; i++)
		{
			System.out.println(arr[i]);
			switch (arr[i])
			{
			case 5:
				count[0]++; break;
			case 6:
				count[1]++; break;
			case 7:
				count[2]++; break;
			case 8:
				count[3]++; break;
			case 9:
				count[4]++; break;
			}
		}
		for (int j = 0; j < 5; j++)
		{
			System.out.println("随机到" + (j+5) + "概率: " + count[j]/10000.0);
		}
		
		
		
		//randomsNoRepeat() 测试
		int[] array = obj.randomsNoRepeat(5, 11, 5);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		
	}
	*/
}
