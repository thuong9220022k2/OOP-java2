package lab1;
import java.util.Scanner;
public class Add2Matrices {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		int iHang, iCot;
		System.out.println("Nhap so hang: ");
		iHang = key.nextInt();
		System.out.println("Nhap so cot: ");
		iCot = key.nextInt();
		int im1[][] = new int[iHang][iCot];
		int im2[][] = new int[iHang][iCot];
		int ikq[][] = new int[iHang][iCot];
		for (int i = 0; i < iHang; i++) {
			for (int j = 0; j < iCot; j++) {
				System.out.print("Nhap gia tri hang "+ i +" cot "+ j +": ");
				im1[i][j] = key.nextInt();
			}
		}
		for (int i = 0; i < iHang; i++) {
			for (int j = 0; j < iCot; j++) {
				System.out.print("Nhap gia tri hang "+ i +" cot "+ j + ": ");
				im2[i][j] = key.nextInt();
			}
		}
		for (int i = 0; i < iHang; i++) {
			for (int j = 0; j < iCot; j++) {
				ikq[i][j] = im1[i][j] + im2[i][j];
			}
		}
		for (int i = 0; i < iHang; i++) {
			for (int j = 0; j < iCot; j++) {
				System.out.print(ikq[i][j] +" ");
			}
			System.out.print("\n");
		}
	}
}
