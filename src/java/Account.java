public class Account {
    
    private int no;
    private int id;
    private String holder;
    private float amount;
    private String password;
    
    public Account (int no, String password, String holder) {
        this.no = no;
        this.password = password;
        this.holder = holder;
        this.amount = 0f;
    }
        
    public boolean checkUser (int no, String password) {
        if (no == this.no) {    
            if (password.equals(this.password)) {
                return true;
            }
        }
        return false;    
    }
    
    public boolean deposit (int no, String password, float amount) {
        if (this.checkUser(no, password)) {
                this.amount += amount;
                return true;
        }
        return false;
    }
    
    public boolean withdraw (int no, String password, float amount, int tono) {
        if (this.checkUser(no, password)) {
            if (holderDao.accountExists(tono)) {
                if (amount > this.amount) {
                    this.amount -= amount;
                    return true;
                }
            }
        }
        return false;        
    }
    
    public int getNo() {
        return no;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public float getAmount() {
        return amount;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
}
