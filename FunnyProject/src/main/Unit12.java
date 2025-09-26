package main;

import java.util.EventListener;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Unit12 extends SelectorComposer<Component> {

	/**
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSoHang1, txtSoHang2, txtTong;

	@Wire
	Button btnMain, btnReset;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}
	
	@Listen("onOK = #txtTong")
	public void onOK() {
		if (!txtTong.getValue().equals("")) {
			if (Integer.valueOf(txtSoHang1.getValue()) + Integer.valueOf(txtSoHang2.getValue()) == Integer
					.valueOf(txtTong.getValue())) {
				txtTong.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				Reload();
			} else {
				txtTong.setValue("");
				txtTong.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
				return;
			}
		} else {
			Messagebox.show("Vui lòng nhập kết quả!", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}
	}
	

	public void Reload() {
		int min = 3, max = 9;
		int random_int2 = 0, random_int1 = 0;
		int sum = 0;
		txtTong.setFocus(true);
		txtSoHang1.setValue("");
		txtTong.setValue("");
		txtSoHang2.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			sum = random_int1 + random_int2;

			txtSoHang1.setValue(String.valueOf(random_int1));
			txtSoHang2.setValue(String.valueOf(random_int2));
		} while (sum > 16 || sum < 10);
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

}
