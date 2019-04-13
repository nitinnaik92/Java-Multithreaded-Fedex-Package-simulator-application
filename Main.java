package myproject;

public class Main {
		// TODO Auto-generated method stub
    	public static void main(String[] args) {
			PacketThread item=new PacketThread ();
			PacketSimulation2 obj=new PacketSimulation2();
			Thread a= new Thread(item);
			Thread b= new Thread(obj);
			a.start();
			b.start();
			GUIWindow sr = new GUIWindow();
			sr.createUI(); 
	}
	
}
