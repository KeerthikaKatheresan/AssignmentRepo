package com.mphasis.Day1MavenProject;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoOnObjectMethodRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String myname="kee kee";
		Supplier<Integer> s=()->myname.length();
		System.out.println(s.get());
		
		//using method refernce
		Supplier<Integer> s1=myname::length;
		System.out.println(s1.get());
		
		
		//Object method refernces
		Hello h=new Hello();
		Supplier<String> s2=h::sayHello;
		System.out.println(s2.get());
		
		NumberUtil obj=new NumberUtil();
		Function<Integer,Integer> f=obj::cube;
		System.out.println(f.apply(5));
		
	
		Predicate<Integer> p=obj::isEven;
		System.out.println(p.test(5));
		
		Function<Double,Double> f1=obj::log;
		System.out.println(f1.apply(67.98));
		
		
		//For printing the array
		int arr[]= {45,5,78,26};
		Consumer<int[]> c=obj::printNum;
		c.accept(arr);
		
		HomeWork hm=new HomeWork();
		String[] s11= {"Kee","Abi","Agi"};
		Function<String,String> f2=hm::printName;
		for(String i:s11)
		{
		System.out.println(f2.apply(i));
		}
		
		Employee emp1=new Employee("Alice", 101, "Developer", "9876543210", 55000);
		Employee emp2 = new Employee("Bob", 102, "Tester", "9123456780", 45000);
		Employee emp3 = new Employee("Charlie", 103, "Manager", "9988776655", 75000);
		Employee[] arr1= {emp1,emp2,emp3};
		Function<Employee,Integer> f3=hm::printBonus;
		for(Employee i:arr1)
		{
			System.out.println(f3.apply(i));
		}
		
		String s111="Keerthika";
		Predicate<String> p1=hm::isValid;
		System.out.println(p1.test(s111));
		
	}
	
}

class Hello{
	public String sayHello()
	{
		return "Vanakam da mapla";
	}
}


class NumberUtil{
	public Integer cube(int num)
	{
		return num*num*num;
	}
	public boolean isEven(int num)
	{
		return num%2==0;
	}
	public double log(double num)
	{
		return Math.log(num);
	}
	
	public void printNum(int[] arr)
	{
		for(int i=0;i<4;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
}

class HomeWork{
	public String printName(String str)
	{
		if(str.startsWith("A"))
		{
			return str;
		}
		return "Idk";
	}
	
	public int printBonus(Employee e)
	{
		int bonus=1000;
		if(e.salary>50000)
		{
			System.out.println("Vachiko:"+bonus);
			e.salary=e.salary+1000;
			return (int) e.salary;
		}
		System.out.println("Tata bhaiya");
		return 0;
	}
	
	public boolean isValid(String s)
	{
		String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return s.matches(regex);
	}
	
	
}