package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

public class Unit6 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5;

	@Wire
	Button btnNum2, btnNum0, btnNum1, btnNum3, btnNum4, btnNum5, btnKiemaTra;

	@Wire
	Button btnMain, btnReset;

	@Wire
	Radio rdLonDenBe, rdBeDenLon;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		Reload();
	}

	public void Reload() {
		int min = 0;
		int max = 10;
		int random_int2 = 0, random_int0 = 0, random_int1 = 0, random_int3 = 0, random_int4 = 0, random_int5 = 0;
		btnNum0.setDisabled(false);
		btnNum1.setDisabled(false);
		btnNum2.setDisabled(false);
		btnNum3.setDisabled(false);
		btnNum4.setDisabled(false);
		btnNum5.setDisabled(false);
		txtNum0.setValue("");
		txtNum1.setValue("");
		txtNum2.setValue("");
		txtNum3.setValue("");
		txtNum5.setValue("");
		txtNum4.setValue("");

		Random random = new Random();
        Set<Integer> numbers = new HashSet<Integer>();

        while (numbers.size() < 6) {
            int num = random.nextInt(10) + 1; // ví dụ chọn từ 1 đến 49
            numbers.add(num); // Set tự động loại bỏ số trùng
        }

        List<Integer> numberList = new ArrayList<Integer>();
        
        random_int4 = numberList.get(0);
        random_int0 = numberList.get(1);
        random_int5 = numberList.get(2);
        random_int3 = numberList.get(3);
        random_int1 = numberList.get(4);
        random_int2 = numberList.get(5);
        
        btnNum0.setLabel(String.valueOf(random_int0));
        btnNum1.setLabel(String.valueOf(random_int1));
        btnNum2.setLabel(String.valueOf(random_int2));
        btnNum3.setLabel(String.valueOf(random_int3));
        btnNum4.setLabel(String.valueOf(random_int4));
        btnNum5.setLabel(String.valueOf(random_int5));
        
		
		
		
	}

	@Listen("onCheck = #rdLonDenBe, #rdBeDenLon")
	public void onCheckSoLon() {
		Reload();
	}

	@Listen("onClick = #btnNum0")
	public void onClickbtnNum0() {
		ClickButton(btnNum0, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}

	@Listen("onClick = #btnNum1")
	public void onClickbtnNum1() {
		ClickButton(btnNum1, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}

	@Listen("onClick = #btnNum2")
	public void onClickbtnNum2() {
		ClickButton(btnNum2, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}

	@Listen("onClick = #btnNum3")
	public void onClickbtnNum3() {
		ClickButton(btnNum3, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}
	
	@Listen("onClick = #btnNum4")
	public void onClickbtnNum4() {
		ClickButton(btnNum4, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}
	
	@Listen("onClick = #btnNum5")
	public void onClickbtnNum5() {
		ClickButton(btnNum5, txtNum0, txtNum1, txtNum2, txtNum3, txtNum4, txtNum5);
	}

	private void ClickButton(Button btn, Textbox txt0, Textbox txt1, Textbox txt2, Textbox txt3, Textbox txt4, Textbox txt5) {
		//btn.setDisabled(true);
		if (txt0.getValue().equals("")) {
			txt0.setValue(btn.getLabel());
		} else if (txt1.getValue().equals("") && !txt0.getValue().equals("")) {
			txt1.setValue(btn.getLabel());
		} else if (txt2.getValue().equals("") && !txt0.getValue().equals("") && !txt1.getValue().equals("")) {
			txt2.setValue(btn.getLabel());
		} else if (txt3.getValue().equals("") && !txt0.getValue().equals("") && !txt1.getValue().equals("")
				&& !txt2.getValue().equals("")) {
			txt3.setValue(btn.getLabel());
		}else if(txt4.getValue().equals("") && !txt3.getValue().equals("") && !txt0.getValue().equals("") && !txt1.getValue().equals("")
				&& !txt2.getValue().equals("")){
			txt4.setValue(btn.getLabel());
		}
		else if(txt5.getValue().equals("") && !txt4.getValue().equals("") && !txt3.getValue().equals("") && !txt0.getValue().equals("") && !txt1.getValue().equals("")
				&& !txt2.getValue().equals("")){
			txt5.setValue(btn.getLabel());
		}
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnKiemaTra")
	public void onClickbtnKiemaTra() {
		if (!txtNum0.getValue().equals("") && !txtNum1.getValue().equals("") && !txtNum2.getValue().equals("")
				&& !txtNum3.getValue().equals("")) {
			if (rdBeDenLon.isChecked() == true) {
				if (Integer.valueOf(txtNum0.getValue()) < Integer.valueOf(txtNum1.getValue())
						&& Integer.valueOf(txtNum1.getValue()) < Integer.valueOf(txtNum2.getValue())
						&& Integer.valueOf(txtNum2.getValue()) < Integer.valueOf(txtNum3.getValue())
						&& Integer.valueOf(txtNum3.getValue()) < Integer.valueOf(txtNum4.getValue())
						&& Integer.valueOf(txtNum4.getValue()) < Integer.valueOf(txtNum5.getValue())) {
					Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
				} else {
					Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
					txtNum0.setValue("");
					txtNum1.setValue("");
					txtNum2.setValue("");
					txtNum3.setValue("");
					txtNum4.setValue("");
					txtNum5.setValue("");
					return;
				}
			} else {
				if (Integer.valueOf(txtNum0.getValue()) > Integer.valueOf(txtNum1.getValue())
						&& Integer.valueOf(txtNum1.getValue()) > Integer.valueOf(txtNum2.getValue())
						&& Integer.valueOf(txtNum2.getValue()) > Integer.valueOf(txtNum3.getValue())
						&& Integer.valueOf(txtNum3.getValue()) > Integer.valueOf(txtNum4.getValue())
						&& Integer.valueOf(txtNum4.getValue()) > Integer.valueOf(txtNum5.getValue())) {
					Messagebox.show("Tuyệt vời!\n10 điểm.", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
				} else {
					Messagebox.show("Sai rồi!\nLàm lại nhé.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
					txtNum0.setValue("");
					txtNum1.setValue("");
					txtNum2.setValue("");
					txtNum3.setValue("");
					txtNum4.setValue("");
					txtNum5.setValue("");
					return;
				}
			}

		} else {
			Messagebox.show("Điền đầy đủ các số vào ô vuông.", "Thông báo", Messagebox.OK, Messagebox.ERROR);
			return;
		}
		Reload();
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		Reload();
	}

}
