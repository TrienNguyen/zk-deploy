package main;

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

public class Unit13 extends SelectorComposer<Component> {

	/**
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

	@Listen("onOK = #txtSoHang1")
	public void onOK() {
		if (!txtSoHang1.getValue().equals("")) {
			if (Integer.valueOf(txtSoHang1.getValue()) + Integer.valueOf(txtSoHang2.getValue()) == Integer
					.valueOf(txtTong.getValue())) {
				txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
			} else {
				txtSoHang1.setValue("");
				txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
				return;
			}
		} else {
			Messagebox.show("Vui lòng chọn kết quả!.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}
		Reload();
	}

	public void Reload() {
		int min = 1, max = 9;
		int random_int2 = 0, random_sum = 0;
		txtSoHang1.setValue("");
		txtTong.setValue("");
		txtSoHang2.setValue("");
		do {
			random_sum = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang2.setValue(String.valueOf(random_int2));
			txtTong.setValue(String.valueOf(random_sum));
		} while (random_sum < random_int2);
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

}
