package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {0,2,4};
        System.out.println(solution(array));
    }
   static boolean solution(int[] arg1) {

        for(int i = 0;i<arg1.length-1;i++){
            if(arg1[i]<0){
                return false;
            }

            if(arg1[i]==0||arg1[i+1]==0){
                return false;
            }

            if((arg1[i+1])%(arg1[i])!=0){

                return false;
            }
        }
        return true;

    }

}
