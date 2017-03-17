/**
 * Created by Shivani Shinde on 17-03-2017.
 */
public interface ICashRegisterDrawer {

    public DrawerStatus getStatus();
    public boolean isOpen();
    public boolean isClose();
    public void Open();
    public void Close();

}
