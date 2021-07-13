package z_homework;

import java.util.Random;
import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		System.out.println("가상의 딜러와 즐길수 있는 21게임을 만들어");
		System.out.println();
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		mainWhile: while (true) {
			int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, c11 = 0, c12 = 0,
					c13 = 0;
			int b1 = 0, b2 = 0, b3 = 0, b4 = 0;
			int p1 = 0, p2 = 0, p3 = 0, p4 = 0;
			boolean flag = true;
			System.out.println("============================");
			System.out.println("1.게임시작\t0.게임종료");
			System.out.println("============================");
			System.out.print("원하는 메뉴를 입력해주세요 >> ");

			switch (sc.nextInt()) {
			case 1:
//게임
				System.out.println("======= 게임 시작 ======");
				System.out.println("------- 1 Round ------");

				System.out.print("뱅커가 한 장의 카드를 뽑았습니다.");
				b1 = rnd.nextInt(13) + 1;
				switch (b1) {
				case 1: c1++; break;
				case 2: c2++; break;
				case 3: c3++; break;
				case 4: c4++; break;
				case 5: c5++; break;
				case 6: c6++; break;
				case 7: c7++; break;
				case 8: c8++; break;
				case 9: c9++; break;
				case 10: c10++; break;
				case 11: c11++; break;
				case 12: c12++; break;
				case 13: c13++; break;
				}
				System.out.println(b1 + "입니다.");

				System.out.print("플레이어가 한 장의 카드를 뽑았습니다.");
				p1 = rnd.nextInt(13) + 1;
				switch (p1) {
				case 1: c1++; break;
				case 2: c2++; break;
				case 3: c3++; break;
				case 4: c4++; break;
				case 5: c5++; break;
				case 6: c6++; break;
				case 7: c7++; break;
				case 8: c8++; break;
				case 9: c9++; break;
				case 10: c10++; break;
				case 11: c11++; break;
				case 12: c12++; break;
				case 13: c13++; break;
				}
				System.out.println(p1 + "입니다.");

				System.out.println("뱅커가 히든 카드를 뽑았습니다.");
				b2 = rnd.nextInt(13) + 1;
				switch (b2) {
				case 1: c1++; break;
				case 2: c2++; break;
				case 3: c3++; break;
				case 4: c4++; break;
				case 5: c5++; break;
				case 6: c6++; break;
				case 7: c7++; break;
				case 8: c8++; break;
				case 9: c9++; break;
				case 10: c10++; break;
				case 11: c11++; break;
				case 12: c12++; break;
				case 13: c13++; break;
				}

				System.out.print("플레이어가 히든 카드를 뽑았습니다.");
				p2 = rnd.nextInt(13) + 1;
				switch (p2) {
				case 1: c1++; break;
				case 2: c2++; break;
				case 3: c3++; break;
				case 4: c4++; break;
				case 5: c5++; break;
				case 6: c6++; break;
				case 7: c7++; break;
				case 8: c8++; break;
				case 9: c9++; break;
				case 10: c10++; break;
				case 11: c11++; break;
				case 12: c12++; break;
				case 13: c13++; break;
				}
				System.out.println(p2 + "입니다.");

				if (p1 + p2 > 21)
					break;

				System.out.println();
				System.out.println("더 받으시겠습니까?((1:yes, 0:no)");
				if (sc.nextInt() == 0)
					break;

				System.out.println("------- 2 Round ------");

				System.out.print("뱅커가 한 장의 카드를 뽑았습니다.");

				do {
					b3 = rnd.nextInt(13) + 1;
					switch (b3) {
					case 1: if (c1 < 4) {c1++; flag = false;} break;
					case 2: if (c2 < 4) {c2++; flag = false;} break;
					case 3: if (c3 < 4) {c3++; flag = false;}break;
					case 4: if (c4 < 4) {c4++; flag = false;}break;
					case 5:if (c5 < 4) {c5++;flag = false;}break;
					case 6:if (c6 < 4) {c6++;flag = false;}break;
					case 7:if (c7 < 4) {c7++;flag = false;}break;
					case 8:if (c8 < 4) {c8++;flag = false;}break;
					case 9:if (c9 < 4) {c9++;flag = false;}break;
					case 10:if (c10 < 4) {c10++;flag = false;}break;
					case 11:if (c11 < 4) {c11++;flag = false;}break;
					case 12:if (c12 < 4) {c12++;flag = false;}break;
					case 13:if (c13 < 4) {c13++;flag = false;}break;

					}

				} while (flag);
				flag = true;
				System.out.println(b3 + "입니다.");

				System.out.print("플레이어가 한 장의 카드를 뽑았습니다.");

				do {
					p3 = rnd.nextInt(13) + 1;
					switch (p3) {
					case 1: if (c1 < 4) {c1++; flag = false;} break;
					case 2: if (c2 < 4) {c2++; flag = false;} break;
					case 3: if (c3 < 4) {c3++; flag = false;}break;
					case 4: if (c4 < 4) {c4++; flag = false;}break;
					case 5:if (c5 < 4) {c5++;flag = false;}break;
					case 6:if (c6 < 4) {c6++;flag = false;}break;
					case 7:if (c7 < 4) {c7++;flag = false;}break;
					case 8:if (c8 < 4) {c8++;flag = false;}break;
					case 9:if (c9 < 4) {c9++;flag = false;}break;
					case 10:if (c10 < 4) {c10++;flag = false;}break;
					case 11:if (c11 < 4) {c11++;flag = false;}break;
					case 12:if (c12 < 4) {c12++;flag = false;}break;
					case 13:if (c13 < 4) {c13++;flag = false;}break;
					}

				} while (flag);
				flag = true;
				System.out.println(p3 + "입니다.");

				if (b1 + b3 + b4 > 21 && p1 + p3 + p4 > 21) {
					System.out.println("무승부 입니다. 게임을 종료합니다.");
					break;
				} else if (b1 + b3 + b4 > 21) {
					System.out.println("뱅커가 21을 넘겼습니다. 플레이어 승리");
					break;
				} else if (p1 + p3 + p4 > 21) {
					System.out.println("플레이어가 21을 넘겼습니다. 벵커 승리");
					break;
				} else if (b1 + b2 + b3 + b4 == 21 && p1 + p2 + p3 + p4 == 21) {
					System.out.println("플레이어와 뱅커 모두 21점 입니다. 무승부 입니다. 게임이 종료됩니다.");
					break;
				} else if (p1 + p2 + p3 + p4 == 21) {
					System.out.println("플레이어가 21점 달성했습니다.");
					System.out.println("굿");
					break;
				}
				System.out.println("더 받으시겠습니까?((1:yes, 0:no)");
				if (sc.nextInt() == 0)
					break;

				System.out.println("------- LAST Round ------");

				System.out.print("뱅커가 한 장의 카드를 뽑았습니다.");

				do {
					b4 = rnd.nextInt(13) + 1;
					switch (b4) {
					case 1:
						if (c1 < 4) {
							c1++;
							flag = false;
						}
						break;
					case 2:
						if (c2 < 4) {
							c2++;
							flag = false;
						}
						break;
					case 3:
						if (c3 < 4) {
							c3++;
							flag = false;
						}
						break;
					case 4:
						if (c4 < 4) {
							c4++;
							flag = false;
						}
						break;
					case 5:
						if (c5 < 4) {
							c5++;
							flag = false;
						}
						break;
					case 6:
						if (c6 < 4) {
							c6++;
							flag = false;
						}
						break;
					case 7:
						if (c7 < 4) {
							c7++;
							flag = false;
						}
						break;
					case 8:
						if (c8 < 4) {
							c8++;
							flag = false;
						}
						break;
					case 9:
						if (c9 < 4) {
							c9++;
							flag = false;
						}
						break;
					case 10:
						if (c10 < 4) {
							c10++;
							flag = false;
						}
						break;
					case 11:
						if (c11 < 4) {
							c11++;
							flag = false;
						}
						break;
					case 12:
						if (c12 < 4) {
							c12++;
							flag = false;
						}
						break;
					case 13:
						if (c13 < 4) {
							c13++;
							flag = false;
						}
						break;

					}

				} while (flag);
				flag = true;
				System.out.println(b4 + "입니다.");

				System.out.print("플레이어가 한 장의 카드를 뽑았습니다.");

				do {
					p4 = rnd.nextInt(13) + 1;
					switch (p4) {
					case 1:
						if (c1 < 4) {
							c1++;
							flag = false;
						}
						break;
					case 2:
						if (c2 < 4) {
							c2++;
							flag = false;
						}
						break;
					case 3:
						if (c3 < 4) {
							c3++;
							flag = false;
						}
						break;
					case 4:
						if (c4 < 4) {
							c4++;
							flag = false;
						}
						break;
					case 5:
						if (c5 < 4) {
							c5++;
							flag = false;
						}
						break;
					case 6:
						if (c6 < 4) {
							c6++;
							flag = false;
						}
						break;
					case 7:
						if (c7 < 4) {
							c7++;
							flag = false;
						}
						break;
					case 8:
						if (c8 < 4) {
							c8++;
							flag = false;
						}
						break;
					case 9:
						if (c9 < 4) {
							c9++;
							flag = false;
						}
						break;
					case 10:
						if (c10 < 4) {
							c10++;
							flag = false;
						}
						break;
					case 11:
						if (c11 < 4) {
							c11++;
							flag = false;
						}
						break;
					case 12:
						if (c12 < 4) {
							c12++;
							flag = false;
						}
						break;
					case 13:
						if (c13 < 4) {
							c13++;
							flag = false;
						}
						break;

					}

				} while (flag);
				flag = true;
				System.out.println(p4 + "입니다.");
				break;

			case 0:
				break mainWhile;
			}
			System.out.println("뱅커 점수 :" + b1 + " + " + b2 + " +" + b3 + " +" + b4 + "=" + (b1 + b2 + b3 + b4));
			System.out.println("플레이어 점수 :" + p1 + " + " + p2 + " +" + p3 + " +" + p4 + "=" + (p1 + p2 + p3 + p4));
			if (((b1 + b2 + b3 + b4) > 21 && (p1 + p2 + p3 + p4) > 21)
					|| ((b1 + b2 + b3 + b4) == 21 && (p1 + p2 + p3 + p4) == 21)) {
				System.out.println("무승부 입니다.");
			} else if ((b1 + b2 + b3 + b4) > 21) {
				System.out.println("뱅커가 21을 넘겼습니다. 플레이어 승리");
			} else if ((p1 + p2 + p3 + p4) > 21) {
				System.out.println("플레이어가 21을 넘겼습니다.뱅커 승리");
			} else if ((b1 + b2 + b3 + b4) == 21) {
				System.out.println("뱅커가 21을 달성했습니다. 벵커 승리");
			} else if ((p1 + p2 + p3 + p4) == 21) {
				System.out.println("플레이어가 21을 달성했습니다. 플레이어 승리");
				System.out.println("굿");
			} else if ((b1 + b2 + b3 + b4) - (p1 + p2 + p3 + p4) > 0) {
				System.out.println("뱅커가 21에 더 근접하여 승리하였습니다.");
			} else {
				System.out.println("플레이어가 21에 더 근접하여 승리하였습니다.");
			}
			System.out.println();
			System.out.println();
			System.out.println();

		}
		sc.close();
	}

}
