import java.util.*;

interface MienGiam {
    long tinhGiam(long hocPhi);
}

class ConChinhSach implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return hocPhi * 50 / 100;
    }
}

class HoNgheo implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return hocPhi * 70 / 100;
    }
}

class HocBong implements MienGiam {
    @Override
    public long tinhGiam(long hocPhi) {
        return Math.min(hocPhi, 3000000);
    }
}

abstract class SinhVien {
    protected static final long DON_GIA = 450000;

    protected String ma;
    protected String maHe;
    protected int soTinChi;
    protected MienGiam mienGiam;

    public SinhVien(String ma, String maHe, int soTinChi) {
        this.ma = ma;
        this.maHe = maHe;
        this.soTinChi = soTinChi;
    }

    public String getMaHe() {
        return maHe;
    }

    public void setMienGiam(MienGiam mienGiam) {
        this.mienGiam = mienGiam;
    }

    public abstract long hocPhi();

    public long soTienGiam() {
        return mienGiam == null ? 0 : mienGiam.tinhGiam(hocPhi());
    }

    public long phaiNop() {
        return hocPhi() - soTienGiam();
    }

    @Override
    public String toString() {
        return ma + " " + maHe + " " + hocPhi() + " " + soTienGiam() + " " + phaiNop();
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
        return soTinChi * DON_GIA * 3 / 2;
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

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<SinhVien> ds = new ArrayList<>();
        HashMap<String, SinhVien> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String maHe = sc.next();
            String ma = sc.next();
            int tc = sc.nextInt();
            SinhVien sv;
            switch (maHe) {
                case "CQ":
                    sv = new SinhVienChinhQuy(ma, tc);
                    break;
                case "CLC":
                    sv = new SinhVienChatLuongCao(ma, tc);
                    break;
                default:
                    sv = new SinhVienLienThong(ma, tc);
            }
            ds.add(sv);
            map.put(ma, sv);
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String ma = sc.next();
            String cs = sc.next();
            SinhVien sv = map.get(ma);
            if (sv == null) {
                System.out.println("NOT FOUND " + ma);
                continue;
            }
            switch (cs) {
                case "CS":
                    sv.setMienGiam(new ConChinhSach());
                    break;
                case "HN":
                    sv.setMienGiam(new HoNgheo());
                    break;
                case "HB":
                    sv.setMienGiam(new HocBong());
                    break;
            }
        }

        for (SinhVien sv : ds) {
            System.out.println(sv);
        }

        String[] cacHe = {"CQ", "CLC", "LT"};
        for (String he : cacHe) {
            int dem = 0;
            long tong = 0;
            for (SinhVien sv : ds) {
                if (sv.getMaHe().equals(he)) {
                    dem++;
                    tong += sv.phaiNop();
                }
            }
            if (dem > 0) {
                System.out.println(he + " " + dem + " " + tong);
            }
        }
        sc.close();
    }
}