# Bài tập Ktra OOP

## Thông tin sinh viên
- **Họ và tên:** Hồ Văn An
- **Mã sinh viên:** B25DCCC001
- **Lớp:** D25CQCC01

## Mô tả
Chương trình Java đọc danh sách sinh viên từ bàn phím, chuẩn hóa họ tên và ngày sinh, sau đó in ra danh sách đã chuẩn hóa.

## Cấu trúc
- `Main.java`: chứa lớp `SinhVien` và lớp `Main` (chương trình chính).

## Hướng dẫn chạy chương trình

### Yêu cầu
- Đã cài đặt JDK (Java Development Kit), khuyến nghị JDK 8 trở lên.
- Có thể kiểm tra bằng lệnh:
  ```bash
  java -version
  javac -version
  ```

### Biên dịch và chạy
Mở terminal tại thư mục `Ktra OOp` và thực hiện:

```bash
javac Main.java
java Main
```

### Định dạng dữ liệu nhập
- Dòng 1: số nguyên `n` - số lượng sinh viên.
- Với mỗi sinh viên, nhập lần lượt 3 dòng:
  1. Mã sinh viên
  2. Họ tên
  3. Ngày sinh (định dạng `d/m/yyyy` hoặc `dd/mm/yyyy`)

### Ví dụ
**Input:**
```
2
B21DCCN001
  nGuYen   vAn   aN
1/2/2003
B21DCCN002
le   thi b
12/10/2003
```

**Output:**
```
B21DCCN001 Nguyen Van An 01/02/2003
B21DCCN002 Le Thi B 12/10/2003
```