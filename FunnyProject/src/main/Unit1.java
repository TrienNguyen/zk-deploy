package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Image;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class Unit1 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSum;

	@Wire
	Button txtNum1, txtNum2;

	@Wire
	Button btnMain, btnReset;

	@Wire
	Image imgDau;

	@Wire
	Radio rdChonSoLon, rdChonSoBe;

	int Sum = 0, Dung = 0, Sai = 0;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	public void Reload() {
		int min = 1;
		int max = 10;
		int random_int2 = 0, random_int1 = 0;
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			txtNum1.setLabel(String.valueOf(random_int1));
			txtNum2.setLabel(String.valueOf(random_int2));
		} while (!(random_int1 != random_int2));

		txtSum.setValue("Kết quả: " + String.valueOf(Dung) + "/" + String.valueOf(Sum));
	}

	@Listen("onCheck = #rdChonSoLon")
	public void onCheckSoLon() {
		Sum = 0;
		Dung = 0;
		Sai = 0;
		imgDau.setSrc("/image/dauLonHon.png");
		Reload();
	}

	@Listen("onCheck = #rdChonSoBe")
	public void onCheckSoBe() {
		Sum = 0;
		Dung = 0;
		Sai = 0;
		imgDau.setSrc("/image/dauBeHon.png");
		Reload();
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Sum = 0;
		Dung = 0;
		Sai = 0;
		rdChonSoLon.setChecked(true);
		Reload();
	}

	@Listen("onClick = #txtNum1")
	public void onClickTextbox1() {
		Sum++;

		if (rdChonSoLon.isChecked() == true) {
			if (Integer.valueOf(txtNum1.getLabel()) > Integer.valueOf(txtNum2.getLabel())) {
				Dung++;
			} else {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			}
		} else {
			if (Integer.valueOf(txtNum1.getLabel()) < Integer.valueOf(txtNum2.getLabel())) {
				Dung++;
			} else {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			}
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

	@Listen("onClick = #txtNum2")
	public void onClickTextbox2() {
		Sum++;
		if (rdChonSoLon.isChecked() == true) {
			if (Integer.valueOf(txtNum2.getLabel()) > Integer.valueOf(txtNum1.getLabel())) {
				Dung++;
			} else {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			}
		} else {
			if (Integer.valueOf(txtNum2.getLabel()) < Integer.valueOf(txtNum1.getLabel())) {
				Dung++;
			} else {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			}
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

}
