import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021, 10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021, 9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021, 12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021, 8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021, 11, 9), "スクールの課題を解く", false));

		//個数取得
		long x = list.stream().filter(f -> f.isDone() == false).count();
		System.out.println("未完了のタスクの個数は" + x);
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");

		//未完了タスクを昇順に並び替えて出力
		list.stream() // Streamを生成
				.filter(f -> f.isDone() == false)
				.sorted(Comparator.comparing(f2 -> f2.getDate()))
				.forEach(System.out::println); // 終端操作: 標準出力
	}
}
