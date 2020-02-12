# XiDachVietnam-OptimalStrategy-Java
 Project to find optimal strategy in Xi Dach Vietnam (different from BlackJack)

Tết này chơi Xì Lát thua quá nên mình lên mạng nghiên cứu lại cách chơi, mình đã đọc qua bài viết Blackjack trên wikipedia: https://en.wikipedia.org/wiki/Blackjack#Basic_strategy

Trên này có nói rất chi tiết về luật chơi cũng như hướng dẫn về basic & optimal strategy dựa theo xác suất thống kê. Nhưng mà, đọc một hồi mình mới nhận ra, luật chơi của Blackjack thực ra khác khá xa trò Xì Lát ở Việt Nam. Vậy nên ko có áp dụng optimal strategy này được.

Thế là mình quyết định sẽ tự tìm chiến thuật tối ưu bằng cách kéo máy ra code: mình test từng chiến thuật bằng cách sửa code rồi kiểm tra kết quả sau mỗi 1.000.000 ván. Cái nào cho kết quả "tích cực" nhất thì là optimal.

Kịch bản chơi là 1 nhà cái đánh với 1 cửa, điều mình cần là tìm ra chiến thuật để nhà cái ăn nhiều tiền nhất. Cửa được rút bài trước, nhà cái rút bài sau. Trạng thái (số lá bài đã rút) của cửa sẽ là thông tin để nhà cái đưa ra quyết định.

Số tiền ban đầu của nhà cái là 0, mỗi ván thắng tăng 1, thua trừ 1, hòa không đổi. Sau mỗi 1 triệu ván bài thì kiểm tra số tiền hiện tại của nhà cái, nếu tiền càng nhiều thì chiến thuật đánh là càng tối ưu. Đây là kết quả mình thu được sau lần test đầu tiên (cài theo chiến thuật mà mình thường dùng khi chơi): 13.043

Mình thử chạy vài chiến thuật khác thì nhận ra chiến thuật đầu tiên cũng là tối ưu nhất luôn (Tết này thua là do đen bạc thôi hehe).

Con số 13.043 có nghĩa là sau 1 triệu ván bài với mức cược 1 đồng, nhà cái sẽ thắng 13.043 đồng (mình không quan tâm win/lose ratio vì con số này ko trực quan bằng). 13.043 là giá trị của lần test thứ 1, test thêm 4 lần với cùng chiến thuật thì giá trị cũng xoay quanh mức 13 ngàn.

Như vậy, có thể đi đến kết luận: nếu áp dụng đúng theo chiến thuật đưa ra, cứ sau mỗi 1.000.000/13.000 = 77 ván bài mình cầm cái đánh với 1 cửa, theo kỳ vọng, mình sẽ ăn được 1 đồng. Còn nếu mỗi ván mình cầm cái đánh với 4 cửa thì chưa đầy 20 ván mình sẽ ăn 1 đồng.
