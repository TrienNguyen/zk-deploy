package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class Main extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Button btnUnit1, btnUnit2, btnUnit3, btnUnit4;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}

	@Listen("onClick = #btnUnit1")
	public void onClickbtnUnit1() {
		Executions.sendRedirect("/zul_file/Unit1.zul");
	}
	
	@Listen("onClick = #btnUnit2")
	public void onClickbtnUnit2() {
		Executions.sendRedirect("/zul_file/Unit2.zul");
	}
	
	@Listen("onClick = #btnUnit3")
	public void onClickbtnUnit3() {
		Executions.sendRedirect("/zul_file/Unit3.zul");
	}
	
	@Listen("onClick = #btnUnit4")
	public void onClickbtnUnit4() {
		Executions.sendRedirect("/zul_file/Unit4.zul");
	}
	
	@Listen("onClick = #btnUnit5")
	public void onClickbtnUnit5() {
		Executions.sendRedirect("/zul_file/Unit5.zul");
	}
	
	@Listen("onClick = #btnUnit6")
	public void onClickbtnUnit6() {
		Executions.sendRedirect("/zul_file/Unit6.zul");
	}
	
	@Listen("onClick = #btnUnit7")
	public void onClickbtnUnit7() {
		Executions.sendRedirect("/zul_file/Unit7.zul");
	}
	
	@Listen("onClick = #btnUnit9")
	public void onClickbtnUnit9() {
		Executions.sendRedirect("/zul_file/Unit9.zul");
	}
	
	@Listen("onClick = #btnUnit8")
	public void onClickbtnUnit8() {
		Executions.sendRedirect("/zul_file/Unit8.zul");
	}
	
	@Listen("onClick = #btnUnit10")
	public void onClickbtnUnit10() {
		Executions.sendRedirect("/zul_file/Unit10.zul");
	}
	
	@Listen("onClick = #btnUnit11")
	public void onClickbtnUnit11() {
		Executions.sendRedirect("/zul_file/Unit11.zul");
	}
	
	@Listen("onClick = #btnUnit12")
	public void onClickbtnUnit12() {
		Executions.sendRedirect("/zul_file/Unit12.zul");
	}
	
	@Listen("onClick = #btnUnit13")
	public void onClickbtnUnit13() {
		Executions.sendRedirect("/zul_file/Unit13.zul");
	}
	
	@Listen("onClick = #btnUnit14")
	public void onClickbtnUnit14() {
		Executions.sendRedirect("/zul_file/Unit14.zul");
	}
	
	@Listen("onClick = #btnUnit15")
	public void onClickbtnUnit15() {
		Executions.sendRedirect("/zul_file/Unit15.zul");
	}
	
	@Listen("onClick = #btnUnit16")
	public void onClickbtnUnit16() {
		Executions.sendRedirect("/zul_file/Unit16.zul");
	}
	
	@Listen("onClick = #btnUnit17")
	public void onClickbtnUnit17() {
		Executions.sendRedirect("/zul_file/Unit17.zul");
	}
	
	@Listen("onClick = #btnUnit18")
	public void onClickbtnUnit18() {
		Executions.sendRedirect("/zul_file/Unit18.zul");
	}
	
	@Listen("onClick = #btnClock")
	public void onClickbtnClock() {
		Executions.sendRedirect("/zul_file/Clock.zul");
	}
	
}
