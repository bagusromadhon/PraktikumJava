import java.util.Map;

public class Student {
    public void displayBooks(Map<String, String[]> bookList) {
        System.out.println("List of Books:");
        System.out.println("NO\tid buku\t\tnamabuku\t\tauthor\t\tcategory\tstock");
        int nomer = 0;
        for (Map.Entry<String, String[]> entry : bookList.entrySet()) {
            nomer++;
            String[] book = entry.getValue();
            System.out.println(entry.getKey() + "\t" + nomer + "\t\t" + book[0] + "\t\t" + book[1] + "\t\t" + book[2] + "\t\t" + book[3] + "\t\t");
        }
    }

    public void logout() {
        System.out.println("Logout");
    }


    public void menuStudent(java.util.Scanner scanner) {
//        displayBooks(Main.bookList);
        logout();
    }
}