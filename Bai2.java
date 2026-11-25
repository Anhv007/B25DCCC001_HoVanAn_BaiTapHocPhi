import java.util.*;

abstract class SinhVien {
    protected static final long DON_GIA = 450000;

    protected String ma;
    protected String maHe;
    protected int soTinChi;

    public SinhVien(String ma, String maHe, int soTinChi) {
        this.ma = ma;
        this.maHe = maHe;
        this.soTinChi = soTinChi;
    }

    public abstract long hocPhi();

    @Override
    public String toString() {
        return ma + " " + maHe + " " + hocPhi();
    }
}

class SinhVienChinhQuy extends SinhVien {
    public SinhVienChinhQuy(String ma, int soTinChi) {
        super(ma, "CQ", soTinChi);
    }

    @Override
    public long hocPhi() {
        return soTinChi * DON_GIA;
    }
}

class SinhVienChatLuongCao extends SinhVien {
    public SinhVienChatLuongCao(String ma, int soTinChi) {
        super(ma, "CLC", soTinChi);
    }

    @Override
    public long hocPhi() {
        return soTinChi * DON_GIA * 3 / 2; // nhân 1,5
    }
}

class SinhVienLienThong extends SinhVien {
    private static final long PHI_QUAN_LY = 2000000;

    public SinhVienLienThong(String ma, int soTinChi) {
        super(ma, "LT", soTinChi);
    }

    @Override
    public long hocPhi() {
        return soTinChi * DON_GIA + PHI_QUAN_LY;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SinhVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String maHe = sc.next();
            String ma = sc.next();
            int tc = sc.nextInt();
            switch (maHe) {
                case "CQ":
                    ds.add(new SinhVienChinhQuy(ma, tc));
                    break;
                case "CLC":
                    ds.add(new SinhVienChatLuongCao(ma, tc));
                    break;
                case "LT":
                    ds.add(new SinhVienLienThong(ma, tc));
                    break;
            }
        }
        for (SinhVien sv : ds) {
            System.out.println(sv);
        }
        sc.close();
    }
}