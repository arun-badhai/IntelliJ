import java.io.IOException;

/**
 * Created by Shivani Shinde on 17-03-2017.
 */
public class CashRegisterDrawer implements ICashRegisterDrawer{
    private DrawerStatus status;

    public CashRegisterDrawer(){
        this.status = DrawerStatus.Closed;
    }
    @Override
    public DrawerStatus getStatus() {
        return this.status;
    }

    @Override
    public boolean isOpen() {
        return this.status == DrawerStatus.Open;
    }

    @Override
    public boolean isClose() {
        return this.status == DrawerStatus.Closed;
    }

    @Override
    public void Open() {
        this.status = DrawerStatus.Open;
    }

    @Override
    public void Close() {
        this.status = DrawerStatus.Closed;
    }
}
