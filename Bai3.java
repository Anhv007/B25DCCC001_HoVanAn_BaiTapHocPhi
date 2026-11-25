import java.util.*;

class DuLieuKhongHopLeException extends Exception {
    public DuLieuKhongHopLeException(String maSV) {
        super(maSV);
    }
}

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

    public String getMa() {
        return ma;
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

class QuanLyHocPhi {
    private ArrayList<SinhVien> ds = new ArrayList<>();

    public void them(String maHe, String ma, String tinChiStr)
            throws DuLieuKhongHopLeException {
        // 1. Mã hệ phải là CQ, CLC hoặc LT (phân biệt hoa/thường)
        if (!maHe.equals("CQ") && !maHe.equals("CLC") && !maHe.equals("LT")) {
            throw new DuLieuKhongHopLeException(ma);
        }
        // 2. Số tín chỉ phải là số nguyên
        int tc;
        try {
            tc = Integer.parseInt(tinChiStr);
        } catch (NumberFormatException e) {
            throw new DuLieuKhongHopLeException(ma);
        }
        // 3. Số tín chỉ trong đoạn [1, 30]
        if (tc < 1 || tc > 30) {
            throw new DuLieuKhongHopLeException(ma);
        }
        // 4. Mã sinh viên không trùng với sinh viên hợp lệ trước đó
        for (SinhVien sv : ds) {
            if (sv.getMa().equals(ma)) {
                throw new DuLieuKhongHopLeException(ma);
            }
        }

        switch (maHe) {
            case "CQ":
                ds.add(new SinhVienChinhQuy(ma, tc));
                break;
            case "CLC":
                ds.add(new SinhVienChatLuongCao(ma, tc));
                break;
            default:
                ds.add(new SinhVienLienThong(ma, tc));
        }
    }

    public void sapXep() {
        ds.sort((a, b) -> {
            int c = Long.compare(b.hocPhi(), a.hocPhi()); // học phí giảm dần
            return c != 0 ? c : a.getMa().compareTo(b.getMa()); // mã tăng dần
        });
    }

    public long tongHocPhi() {
        long tong = 0;
        for (SinhVien sv : ds) {
            tong += sv.hocPhi();
        }
        return tong;
    }

    public ArrayList<SinhVien> getDs() {
        return ds;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        QuanLyHocPhi ql = new QuanLyHocPhi();

        for (int i = 0; i < n; i++) {
            String maHe = sc.next();
            String ma = sc.next();
            String tc = sc.next();
            try {
                ql.them(maHe, ma, tc);
            } catch (DuLieuKhongHopLeException e) {
                System.out.println("INVALID " + e.getMessage());
            }
        }

        ql.sapXep();
        for (SinhVien sv : ql.getDs()) {
            System.out.println(sv);
        }
        System.out.println("TONG " + ql.tongHocPhi());
        sc.close();
    }
}