package safemeeting.observer;

import safemeeting.model.*;

public class ObserverPatternTest {

	public static void main(String[] args) {
		
		PrenotaBean pb = new PrenotaBean();
		
		Observer obj1 = new StudenteBean("0512104841");
		Observer obj2 = new StudenteBean("0512104565");
		Observer obj3 = new StudenteBean("0512104820");
		
		pb.registerObserver(obj1);
		pb.registerObserver(obj2);
		pb.registerObserver(obj3);
		
		obj1.setSubject(pb);
		obj2.setSubject(pb);
		obj3.setSubject(pb);
		
		obj1.update();
		
		pb.postMessage("New Message");

	}

}
