import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Invitation {
    private final InvitationDistance mInvitationDistance;

    public Invitation(final InvitationDistance invitationDistance) {
        this.mInvitationDistance = invitationDistance;
    }

    /**
     * @param customers
     * @return invited customers based on priority (user id in ascending order)
     */
    public PriorityQueue<Customer> findCustomersWithinDublin(final String customers) {
        final PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>();

        final List<Customer> customerList = deSerializeCustomers(customers);
        final Iterator<Customer> iterable = customerList.iterator();
        while (iterable.hasNext()) {
            final Customer customer = iterable.next();
            final boolean isCustomerAllowed =
                    this.mInvitationDistance.isWithinBoundary(customer.getLatitude(), customer.getLongitude());
            if (isCustomerAllowed) {
                customerPriorityQueue.add(iterable.next());
            }
        }
        return customerPriorityQueue;
    }

    /**
     * deserialize a string resource into a list of customers.
     *
     * @param customers
     * @return
     */
    private List<Customer> deSerializeCustomers(final String customers) {
        final Type customerType = new TypeToken<ArrayList<Customer>>() {
        }.getType();
        return new Gson().fromJson(customers, customerType);
    }
}
