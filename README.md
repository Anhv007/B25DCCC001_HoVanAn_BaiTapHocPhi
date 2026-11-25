# Bài tập Ktra OOP

## Thông tin sinh viên
- **Họ và tên:** Hồ Văn An
- **Mã sinh viên:** B25DCCC001
- **Lớp:** D25CQCC01

## Mô tả
Repository chứa mã nguồn Java cho các bài tập kiểm tra OOP.

## Cấu trúc
- `Bai1.java`: Đọc danh sách sinh viên, chuẩn hóa họ tên và ngày sinh, in ra danh sách đã chuẩn hóa.
- `Bai2.java`: Quản lý học phí sinh viên theo hệ đào tạo (CQ, CLC, LT).
- `Bai3.java`: Quản lý học phí có kiểm tra dữ liệu không hợp lệ, sắp xếp và tính tổng học phí.
- `Bai4.java`: Quản lý học phí có áp dụng chính sách miễn giảm (con chính sách, hộ nghèo, học bổng).

## Hướng dẫn chạy chương trình

### Yêu cầu
- Đã cài đặt JDK (Java Development Kit), khuyến nghị JDK 8 trở lên.
- Kiểm tra phiên bản:
  ```bash
  java -version
  javac -version
  ```

### Biên dịch và chạy

Mở terminal tại thư mục project và chạy bài tương ứng:

```bash
javac Bai1.java
java Bai1
```

```bash
javac Bai2.java
java Bai2
```

```bash
javac Bai3.java
java Bai3
```

```bash
javac Bai4.java
java Bai4
```

## Ví dụ Bài 1

### Định dạng dữ liệu nhập
- Dòng 1: số nguyên `n` - số lượng sinh viên.
- Với mỗi sinh viên, nhập lần lượt 3 dòng:
  1. Mã sinh viên
  2. Họ tên
  3. Ngày sinh (`d/m/yyyy` hoặc `dd/mm/yyyy`)

### Input
```
2
B21DCCN001
  nGuYen   vAn   aN
1/2/2003
B21DCCN002
le   thi b
12/10/2003
```

### Output
```
B21DCCN001 Nguyen Van An 01/02/2003
B21DCCN002 Le Thi B 12/10/2003
```