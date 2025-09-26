package main;

import java.util.Random;

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

public class Unit15 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSoHang11, txtSoHang12, txtSoHang13, txtHieu1, txtSoHang21, txtSoHang22, txtSoHang23, txtHieu2,
			txtSoHang31, txtSoHang32, txtSoHang33, txtHieu3, txtSoHang01, txtSoHang02, txtSoHang03, txtHieu0;

	@Wire
	Button btnMain, btnReset, btnCheck;

	boolean isTrue0 = true, isTrue1 = true, isTrue2 = true, isTrue3 = true;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		ArrayPattern();
		Reload0();
		Reload1();
		Reload2();
		Reload3();
	}

	@Listen("onClick = #btnCheck")
	public void onClickbtnCheck() {
		Check(txtSoHang01, txtSoHang02, txtSoHang03, txtHieu0, 0);
		Check(txtSoHang11, txtSoHang12, txtSoHang13, txtHieu1, 1);
		Check(txtSoHang21, txtSoHang22, txtSoHang23, txtHieu2, 2);
		Check(txtSoHang31, txtSoHang32, txtSoHang33, txtHieu3, 3);

		if (isTrue0 == true && isTrue1 == true && isTrue2 == true && isTrue3 == true) {
			Reload0();
			Reload1();
			Reload2();
			Reload3();
		}
	}

	public void Reload0() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang01.setValue("");
		txtHieu0.setValue("");
		txtSoHang02.setValue("");
		txtSoHang03.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 2) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang01.setValue(String.valueOf(random_int1));
			txtSoHang02.setValue(String.valueOf(random_int2));
			txtSoHang03.setValue(String.valueOf(random_int3));
		} while ((random_int1 - random_int2 - random_int3) <= 0);
	}

	public void Reload1() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang11.setValue("");
		txtHieu1.setValue("");
		txtSoHang12.setValue("");
		txtSoHang13.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 2) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang11.setValue(String.valueOf(random_int1));
			txtSoHang12.setValue(String.valueOf(random_int2));
			txtHieu1.setValue(String.valueOf(random_int3));
		} while ((random_int1 - random_int2 - random_int3) <= 0);
	}

	public void Reload2() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang21.setValue("");
		txtHieu2.setValue("");
		txtSoHang22.setValue("");
		txtSoHang23.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 2) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang21.setValue(String.valueOf(random_int1));
			txtSoHang23.setValue(String.valueOf(random_int2));
			txtHieu2.setValue(String.valueOf(random_int3));
		} while ((random_int1 - random_int2 - random_int3) <= 0);
	}

	public void Reload3() {
		int min = 1, max = 9;
		int random_int2 = 0, random_int1 = 0, random_int3 = 0;
		txtSoHang31.setValue("");
		txtHieu3.setValue("");
		txtSoHang32.setValue("");
		txtHieu3.setValue("");
		do {
			random_int1 = (int) Math.floor(Math.random() * (max - min + 2) + min);
			random_int2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
			random_int3 = (int) Math.floor(Math.random() * (max - min + 1) + min);

			txtSoHang33.setValue(String.valueOf(random_int1));
			txtSoHang32.setValue(String.valueOf(random_int2));
			txtHieu3.setValue(String.valueOf(random_int3));
		} while ((random_int1 + random_int2 + random_int3) >= 10);
	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		ArrayPattern();
		Reload0();
		Reload1();
		Reload2();
		Reload3();
	}

	public void ArrayPattern() {

		 int length = 12;   // độ dài mảng
	        int K = 10;        // tổng 4 số liên tiếp
	        int[] arr = new int[length];
	        Random rand = new Random();

	        // Sinh 3 số đầu ngẫu nhiên
	        arr[0] = rand.nextInt(6); // ví dụ: giá trị 0..5
	        arr[1] = rand.nextInt(6);
	        arr[2] = rand.nextInt(6);

	        // Tính số thứ 4 để đảm bảo tổng = K
	        arr[3] = K - (arr[0] + arr[1] + arr[2]);

	        // Sinh chu kỳ 4 cho các phần tử còn lại
	        for (int i = 4; i < length; i++) {
	            arr[i] = arr[i - 4];
	        }

	        // In mảng
	        System.out.print("Mảng: ");
	        for (int x : arr) {
	            System.out.print(x + " ");
	        }
	}

	public void Check(Textbox txtSoHang1, Textbox txtSoHang2, Textbox txtSoHang3, Textbox txtTong, int Row) {

		if (!txtSoHang1.getValue().equals("") && !txtSoHang2.getValue().equals("")
				&& !txtSoHang3.getValue().equals("")) {
			if (Integer.valueOf(txtSoHang1.getValue()) - Integer.valueOf(txtSoHang2.getValue())
					- Integer.valueOf(txtSoHang3.getValue()) == Integer.valueOf(txtTong.getValue())) {
				txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtSoHang2.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtSoHang3.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				txtTong.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #00FFCC");
				if (Row == 0)
					isTrue1 = true;
				if (Row == 0)
					isTrue1 = true;
				if (Row == 2)
					isTrue2 = true;
				if (Row == 3)
					isTrue3 = true;
			} else {

				if (Row == 0) {
					txtTong.setValue("");
					txtTong.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue0 = false;
				}

				if (Row == 1) {
					txtSoHang3.setValue("");
					txtSoHang3.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue1 = false;
				}
				if (Row == 2) {
					txtSoHang2.setValue("");
					txtSoHang2.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue2 = false;
				}
				if (Row == 3) {
					txtSoHang1.setValue("");
					txtSoHang1.setStyle("text-align:center; font-size: 70px;font-weight: bold; background: #FF6A6A");
					isTrue3 = false;
				}
				return;
			}

		} else {
			Messagebox.show("Vui lòng điền đầy đủ số hạng!", "Thông báo", Messagebox.OK, Messagebox.ON_OK);
			return;
		}

	}

}
