package api.objects;

public class CustomerDefaults {
    private CustomerRef customerRef1=new CustomerRef();
    private CustomerRef customerRef2=new CustomerRef();
    private CustomerRef customerRef3=new CustomerRef();

    public CustomerRef getCustomerRef1() {
        return customerRef1;
    }

    public void setCustomerRef1(CustomerRef customerRef1) {
        this.customerRef1 = customerRef1;
    }

    public CustomerRef getCustomerRef2() {
        return customerRef2;
    }

    public void setCustomerRef2(CustomerRef customerRef2) {
        this.customerRef2 = customerRef2;
    }

    public CustomerRef getCustomerRef3() {
        return customerRef3;
    }

    public void setCustomerRef3(CustomerRef customerRef3) {
        this.customerRef3 = customerRef3;
    }
}
