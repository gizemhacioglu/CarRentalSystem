package project;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class ABook {


    public abstract LocalDate addBookingDate();

    public abstract void deleteBookingDate(int index, int customerIndex);

    public abstract void editEndDate(int customerType, int index);

}
