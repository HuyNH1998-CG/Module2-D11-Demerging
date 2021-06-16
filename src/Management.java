import java.util.Queue;
import java.util.Scanner;

public class Management {
    public static void showAll(NhanVien[] arr) {
        for (NhanVien n : arr) {
            System.out.println(n);
        }
    }
    public static NhanVien[] addFulltime(NhanVien[] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Adding full-time employee");
        System.out.println("Input Name");
        String name = input.nextLine();
        System.out.println("Input gender");
        String gender = input.nextLine().toLowerCase();
        NhanVien nv = new NhanVienFulltime(name,gender);
        NhanVien[] newArr = new NhanVien[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[newArr.length - 1] = nv;
        return newArr;
    }
    public static void getBelowAverage(NhanVien[] arr){
        int average = 0;
        int count =0;
        for(NhanVien n : arr){
            if (n instanceof NhanVienFulltime){
                average += ((NhanVienFulltime) n).getSalary();
                count ++;
            }
        }
        average /= count;
        System.out.println("Company's full-time employee average salary is:" + average);
        for(NhanVien n : arr){
            if (n instanceof NhanVienFulltime){
                if(((NhanVienFulltime) n).getSalary() < average){
                    System.out.println(n);
                }
            }
        }
    }
    public static NhanVien[] delete(NhanVien[] arr){
        Scanner input = new Scanner(System.in);
        System.out.println("Input employee ID to delete");
        NhanVien[] newArr = new NhanVien[arr.length - 1];
        String id = input.nextLine();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (id.equals(arr[i].getId())) {
                start = i;
            }
        }
        for (int i = start; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = null;
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static void sortGender(NhanVien[] list, Queue<NhanVien> Nu,Queue<NhanVien> Nam){
        for (NhanVien n : list) {
            if (n.getGender().equals("nu")) {
                Nu.add(n);
            } else if (n.getGender().equals("nam")) {
                Nam.add((n));
            }
        }
        NhanVien[] newList = new NhanVien[list.length];
        int index = 0;
        while (!Nu.isEmpty()) {
            newList[index] = Nu.remove();
            index++;
        }
        while (!Nam.isEmpty()) {
            newList[index] = Nam.remove();
            index++;
        }
        list = newList;
        for(NhanVien n: list){
            System.out.println(n);
        }
    }
}
