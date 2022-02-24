package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Cart;

public class EmptyCartCommand extends FrontCommand {

    @Override
    void process() throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.getCart().clear();
        session.setAttribute("cart", cart);
        forward("/shoppingcartview.jsp");
    }
}
