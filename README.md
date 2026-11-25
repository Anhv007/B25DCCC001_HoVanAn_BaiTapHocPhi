# Bài tập Ktra OOP

## Thông tin sinh viên
- **Họ và tên:** Hồ Văn An
- **Mã sinh viên:** B25DCCC001
- **Lớp:** D25CQCC01

## Mô tả
Repository chứa mã nguồn Java cho các bài tập kiểm tra OOP.

## Cấu trúc
- `Bai1.java`: Đọc danh sách sinh viên, chuẩn hóa họ tên và ngày sinh, in ra danh sách đã chuẩn hóa.
- `Bai2.java`: File khung cho Bài 2 (cần bổ sung nội dung đề bài/xử lý).

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

**Bài 1:**
```bash
javac Bai1.java
java Bai1
```

**Bài 2:**
```bash
javac Bai2.java
java Bai2
```

### Định dạng dữ liệu nhập (Bài 1)
- Dòng 1: số nguyên `n` - số lượng sinh viên.
- Với mỗi sinh viên, nhập lần lượt 3 dòng:
  1. Mã sinh viên
  2. Họ tên
  3. Ngày sinh (`d/m/yyyy` hoặc `dd/mm/yyyy`)

### Ví dụ Bài 1
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
