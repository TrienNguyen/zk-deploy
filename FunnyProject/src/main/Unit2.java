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

public class Unit2 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtNum1, txtNum2, txtSum, txtSum1;

	@Wire
	Button btnLonHon, btnBeHon, btnBang;

	@Wire
	Button btnMain, btnReset;

	int Sum = 0, Dung = 0, Sai = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	public void Reload() {
		int min = 0;
		int max = 10;
		int random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		int random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
		txtNum1.setValue(String.valueOf(random_int1));
		txtNum2.setValue(String.valueOf(random_int2));
		txtSum.setValue("Kết quả: " + String.valueOf(Dung) + "/" + String.valueOf(Sum));
		btnBeHon.setLabel("<");
		btnBang.setLabel("=");
		btnLonHon.setLabel(">");

	}

	@Listen("onClick = #btnMain")
	public void onClickbtnUnit1() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Sum = 0;
		Dung = 0;
		Sai = 0;
		Reload();
	}

	@Listen("onClick = #btnLonHon")
	public void onClickbtnLonHon() {
		Sum++;
		if (Integer.valueOf(txtNum1.getValue()) > Integer.valueOf(txtNum2.getValue())) {
			Dung++;
		} else {
			Sai++;
			Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
		}
		Reload();
	}

	@Listen("onClick = #btnBeHon")
	public void onClickbtnBeHon() {
		Sum++;
		if (Integer.valueOf(txtNum1.getValue()) < Integer.valueOf(txtNum2.getValue())) {
			Dung++;
		} else {
			Sai++;
			Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
		}
		if (Sum == 30) {
			if (Dung >= 27)
				Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			else
				Messagebox.show("Cần cố gắng thêm nhé!\nKết quả: "+Dung+"/"+Sum+".", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			Sum = 0;
			Dung = 0;
			Sai = 0;
		}
		Reload();
	}

	@Listen("onClick = #btnBang")
	public void onClickbtnBang() {
		Sum++;
		if (Integer.valueOf(txtNum2.getValue()) == Integer.valueOf(txtNum1.getValue())) {
			Dung++;
		} else {
			Sai++;
			Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
		}
		if (Sum == 30) {
			if (Dung >= 27)
				Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			else
				Messagebox.show("Cần cố gắng thêm nhé!\nKết quả: "+Dung+"/"+Sum+"..", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			Sum = 0;
			Dung = 0;
			Sai = 0;
		}
		Reload();
	}
}
