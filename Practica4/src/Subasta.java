
public class Subasta {
    private String book;
    private int currentMaxPrice;
    private boolean open;

    public Subasta(String b, int p, boolean y) {
    	setBook(b); setCurrentMaxPrice(p); setOpen(y);
    }

    public void setBook(String b) {
    	if (b != null) this.book = b;
    }

    public void setCurrentMaxPrice(int p) {
    	this.currentMaxPrice = p;
    }

    public void setOpen(boolean y) {
		this.open = y;
    }

    public String getBook() {
    	return this.book;
    }

    public int getCurrentMaxPrice() {
    	return this.currentMaxPrice;
    }

    public boolean isOpen() {
    	return this.open;
    }

}
