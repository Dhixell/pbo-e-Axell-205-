public class admin extends user {
    private final String username = "admin205";
    private final String password = "password205";

    public admin(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputusername, String inputPassword) {
        return inputusername.equals(username) && inputPassword.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Selamat datang, " + getNama());
    }
}
