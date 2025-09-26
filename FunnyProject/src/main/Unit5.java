package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Window;

public class Unit5 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Button btnPic1, btnPic2, btnPic3,btnMain;

	@Wire
	Image image;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	@Listen("onClick = #btnPic1")
	public void onClickbtnPic1() {
		image.setSrc("/image/sosanh1.png");
	}
	
	@Listen("onClick = #btnPic2")
	public void onClickbtnPic2() {
		image.setSrc("/image/sosanh2.png");
	}
	
	@Listen("onClick = #btnPic3")
	public void onClickbtnPic3() {
		image.setSrc("/image/sosanh3.png");
	}
	
	@Listen("onClick = #btnPic4")
	public void onClickbtnPic4() {
		image.setSrc("/image/sosanh4.png");
	}
	
	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

}
