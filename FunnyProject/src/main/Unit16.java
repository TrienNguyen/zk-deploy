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

public class Unit16 extends SelectorComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire
	Window windowMaster;

	@Wire
	Textbox txtSoHang11, txtSoHang0, txtSoHang1, txtSoHang2, txtSoHang3, txtSoHang4, txtSoHang5, txtSoHang6, txtSoHang7,
			txtSoHang8, txtSoHang9, txtSoHang10;

	@Wire
	Button btnMain, btnReset, btnCheck;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		ArrayPattern();
	}

	@Listen("onClick = #btnCheck")
	public void onClickbtnCheck() {

	}

	@Listen("onClick = #btnMain")
	public void onClickbtnMain() {
		Executions.sendRedirect("/index.zul");
	}

	@Listen("onClick = #btnReset")
	public void onClickbtnReset() {
		ArrayPattern();

	}

	public void ArrayPattern() {

		int length = 12; // độ dài mảng
		int K = 10; // tổng 4 số liên tiếp
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

		txtSoHang0.setValue(String.valueOf(arr[0]));
		txtSoHang5.setValue(String.valueOf(arr[5]));
		txtSoHang10.setValue(String.valueOf(arr[10]));

		// In mảng
		System.out.print("Mảng: ");
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}
}
