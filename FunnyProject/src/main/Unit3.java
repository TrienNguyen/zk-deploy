package main;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;


public class Unit3 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSum;

	@Wire
	Button btnNum, btnNum0, btnNum1;

	@Wire
	Button btnMain, btnReset;

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
		int min = 0;
		int max = 10;
		int random_int = 0, random_int0 = 0, random_int1 = 0;

		do {
			random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int0 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			btnNum.setLabel(String.valueOf(random_int));
			btnNum0.setLabel(String.valueOf(random_int0));
			btnNum1.setLabel(String.valueOf(random_int1));
		} while (!((random_int0 < random_int && random_int < random_int1)
				|| (random_int1 < random_int && random_int < random_int0)));
		txtSum.setValue("Kết quả: " + String.valueOf(Dung) + "/" + String.valueOf(Sum));

	}

	@Listen("onCheck = #rdChonSoLon,#rdChonSoBe")
	public void onCheckSoLon() {
		Sum = 0;
		Dung = 0;
		Sai = 0;
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

	@Listen("onClick = #btnNum0")
	public void onClickbtnNum0() {
		Sum++;
		if (rdChonSoLon.isChecked() == true) {
			if (Integer.valueOf(btnNum0.getLabel()) < Integer.valueOf(btnNum.getLabel())) {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			} else {
				Dung++;
			}
		} else {
			if (Integer.valueOf(btnNum0.getLabel()) > Integer.valueOf(btnNum.getLabel())) {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			} else {
				Dung++;
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

	@Listen("onClick = #btnNum1")
	public void onClickbtnNum1() {
		Sum++;
		if (rdChonSoLon.isChecked() == true) {
			if (Integer.valueOf(btnNum1.getLabel()) < Integer.valueOf(btnNum.getLabel())) {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			} else {
				Dung++;
			}
		} else {
			if (Integer.valueOf(btnNum1.getLabel()) > Integer.valueOf(btnNum.getLabel())) {
				Sai++;
				Messagebox.show("Sai rồi!", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			} else {
				Dung++;
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
