import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<NhanVien> Nam = new LinkedList<>();
        Queue<NhanVien> Nu = new LinkedList<>();
        NhanVien[] list = new NhanVien[0];
        list = Management.addFulltime(list);
        list = Management.addFulltime(list);
        list = Management.addFulltime(list);
        list = Management.addFulltime(list);
        list = Management.addFulltime(list);
        list = Management.addFulltime(list);
        Management.sortGender(list,Nu,Nam);
    }
}
