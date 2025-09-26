package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Unit8 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSoHang1, txtSoHang2, txtTong;

	@Wire
	Button btnMain, btnReset, btnKiemaTra, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	public void Reload() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0;
		txtSoHang1.setValue("");
		txtTong.setValue("");
		txtSoHang2.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang1.setValue(String.valueOf(random_int1));
			txtSoHang2.setValue(String.valueOf(random_int2));
		} while (!((random_int1 + random_int2) < 10));
	}

	@Listen("onClick = #btn1")
	public void onClickbtnTong1() {
		txtTong.setValue(btn1.getLabel());
	}

	@Listen("onClick = #btn2")
	public void onClickbtnTong2() {
		txtTong.setValue(btn2.getLabel());
	}

	@Listen("onClick = #btn3")
	public void onClickbtnTong3() {
		txtTong.setValue(btn3.getLabel());
	}

	@Listen("onClick = #btn4")
	public void onClickbtnTong4() {
		txtTong.setValue(btn4.getLabel());
	}

	@Listen("onClick = #btn5")
	public void onClickbtnTong5() {
		txtTong.setValue(btn5.getLabel());
	}

	@Listen("onClick = #btn6")
	public void onClickbtnTong6() {
		txtTong.setValue(btn6.getLabel());
	}

	@Listen("onClick = #btn7")
	public void onClickbtnTong7() {
		txtTong.setValue(btn7.getLabel());
	}

	@Listen("onClick = #btn8")
	public void onClickbtnTong8() {
		txtTong.setValue(btn8.getLabel());
	}

	@Listen("onClick = #btn9")
	public void onClickbtnTong9() {
		txtTong.setValue(btn9.getLabel());
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnKiemaTra")
	public void onClickbtnKiemaTra() {

		if (!txtTong.getValue().equals("")) {
			if (Integer.valueOf(txtSoHang1.getValue()) + Integer.valueOf(txtSoHang2.getValue()) == Integer
					.valueOf(txtTong.getValue())) {
				Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			} else {
				Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
				return;
			}
		} else {
			Messagebox.show("Vui lòng chọn kết quả!.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}
		Reload();
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

}
