import javafx.application.Application;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application{
	
	private Scene scene1;
	private Scene scene2;
	private Scene gamescene;
	private int player_num;
	private CardFactory factory;
	private int color_select;
	private int card_select ;
	private int challenge;
	private Stage window;
	
	public void start (Stage primaryStage)throws  Exception { 
		window = primaryStage;
	//Menu - Scene 1
		BorderPane menu =new BorderPane();
		
		//Radio btOK to choose number of player
		RadioButton player[] = new RadioButton[3];
		ToggleGroup Chooseplayer = new ToggleGroup();
		
		//All Radio Button Display
		player[0] = new RadioButton("2 Players");
		player[1] = new RadioButton("3 Players");
		player[2] = new RadioButton("4 Players");
		player[0].setToggleGroup(Chooseplayer);
		player[1].setToggleGroup(Chooseplayer);
		player[2].setToggleGroup(Chooseplayer);

		Label label = new Label("Welcome to UNO game!"); //in scene1
		Button btOK = new Button("OK");//in scene1
		
		//Scene one into from layout
		VBox layout_mid = new VBox(10);
		layout_mid.getChildren().addAll(label,player[0],player[1],player[2],btOK);
		menu.setCenter(layout_mid);
		label.setAlignment(Pos.CENTER);
		layout_mid.setAlignment(Pos.CENTER);
		StackPane stackP = new StackPane();
		stackP.getChildren().add(menu);
		scene1 = new Scene(stackP,500,500);
	//End Of Scene 1	
		
		
	//Scene 2 - Button
		Button btBack = new Button("Back");//in scene2
		Button btStart = new Button("Start");//in scene2
		
		btOK.setOnAction(e->{	//Scene 1 Button (Jump to Scene Two)
			if (player[0].isSelected())
				this.player_num=2;
			else if (player[1].isSelected())
				this.player_num=3;
			else if (player[2].isSelected())
				this.player_num = 4;
			else
				return;
			Label label2 = new Label(player_num + " Players version selected");//in scene2
			factory = new CardFactory(player_num);
			VBox layout2 = new VBox(10);
			HBox option = new HBox(30);
			option.getChildren().addAll(btBack,btStart);
			option.setAlignment(Pos.CENTER);
			layout2.getChildren().addAll(label2,option);
			layout2.setAlignment(Pos.CENTER);
			scene2 = new Scene(layout2,600,300);
			primaryStage.setScene(scene2);
		});
		

		btBack.setOnAction(e->{
			factory = new CardFactory(player_num);
			primaryStage.setScene(scene1);
		});
		
		btStart.setOnAction(new update());
		
		//Display Scene 1 first
		primaryStage.setTitle("UNO Game"); 
		primaryStage.setScene(scene1);
		primaryStage.setResizable(true);
		primaryStage.show();
	//End - Scene 2	
	}
	public ImageView setImage(Card temp) {
		ImageView[] card_image = new ImageView[54];
		
		card_image[0] = new ImageView ("1.PNG");//0 1
		card_image[1] = new ImageView ("2.PNG");//0 2
		card_image[2] = new ImageView ("3.PNG");//0 3
		card_image[3] = new ImageView ("4.PNG");//0 4
		card_image[4] = new ImageView ("5.PNG");//0 5
		card_image[5] = new ImageView ("6.PNG");//0 6
		card_image[6] = new ImageView ("7.PNG");//0 7
		card_image[7] = new ImageView ("8.PNG");//0 8
		card_image[8] = new ImageView ("9.PNG");//0 9
		card_image[9] = new ImageView ("10.PNG");//0 0
		card_image[10] = new ImageView ("11.PNG");//1 1
		card_image[11] = new ImageView ("12.PNG");//1 2
		card_image[12] = new ImageView ("13.PNG");//1 3
		card_image[13] = new ImageView ("14.PNG");//1 4
		card_image[14] = new ImageView ("15.PNG");//1 5
		card_image[15] = new ImageView ("16.PNG");//1 6
		card_image[16] = new ImageView ("17.PNG");//1 7
		card_image[17] = new ImageView ("18.PNG");//1 8
		card_image[18] = new ImageView ("19.PNG");//1 9
		card_image[19] = new ImageView ("20.PNG");//1 0
		card_image[20] = new ImageView ("21.PNG");//2 1
		card_image[21] = new ImageView ("22.PNG");//2 2
		card_image[22] = new ImageView ("23.PNG");//2 3
		card_image[23] = new ImageView ("24.PNG");//2 4
		card_image[24] = new ImageView ("25.PNG");//2 5
		card_image[25] = new ImageView ("26.PNG");//2 6
		card_image[26] = new ImageView ("27.PNG");//2 7
		card_image[27] = new ImageView ("28.PNG");//2 8
		card_image[28] = new ImageView ("29.PNG");//2 9
		card_image[29] = new ImageView ("30.PNG");//2 0
		card_image[30] = new ImageView ("31.PNG");//3 1
		card_image[31] = new ImageView ("32.PNG");//3 2
		card_image[32] = new ImageView ("33.PNG");//3 3
		card_image[33] = new ImageView ("34.PNG");//3 4
		card_image[34] = new ImageView ("35.PNG");//3 5
		card_image[35] = new ImageView ("36.PNG");//3 6
		card_image[36] = new ImageView ("37.PNG");//3 7
		card_image[37] = new ImageView ("38.PNG");//3 8
		card_image[38] = new ImageView ("39.PNG");//3 9
		card_image[39] = new ImageView ("40.PNG");//3 0
		card_image[40] = new ImageView ("41.PNG");//0 10
		card_image[41] = new ImageView ("42.PNG");//0 11
		card_image[42] = new ImageView ("43.PNG");//0 12
		card_image[43] = new ImageView ("44.PNG");//1 10
		card_image[44] = new ImageView ("45.PNG");//1 11
		card_image[45] = new ImageView ("46.PNG");//1 12
		card_image[46] = new ImageView ("47.PNG");//2 10
		card_image[47] = new ImageView ("48.PNG");//2 11
		card_image[48] = new ImageView ("49.PNG");//2 12
		card_image[49] = new ImageView ("50.PNG");//3 10
		card_image[50] = new ImageView ("51.PNG");//3 11
		card_image[51] = new ImageView ("52.PNG");//3 12
		card_image[52] = new ImageView ("53.PNG");//5 13
		card_image[53] = new ImageView ("54.PNG");//5 14
		
		if(temp.ref_col()==0) {
			if(temp.ref_sym()==1)
				return card_image[0];
			else if(temp.ref_sym()==2)
				return card_image[1];
			else if(temp.ref_sym()==3)
				return card_image[2];
			else if(temp.ref_sym()==4)
				return card_image[3];
			else if(temp.ref_sym()==5)
				return card_image[4];
			else if(temp.ref_sym()==6)
				return card_image[5];
			else if(temp.ref_sym()==7)
				return card_image[6];
			else if(temp.ref_sym()==8)
				return card_image[7];
			else if(temp.ref_sym()==9)
				return card_image[8];
			else if(temp.ref_sym()==0)
				return card_image[9];
			else if(temp.ref_sym()==10)
				return card_image[40];
			else if(temp.ref_sym()==11)
				return card_image[41];
			else if(temp.ref_sym()==12)
				return card_image[42];
		}
	    if(temp.ref_col()==1) {
			if(temp.ref_sym()==1)
				return card_image[10];
			else if(temp.ref_sym()==2)
					return card_image[11];
			else if(temp.ref_sym()==3)
				return card_image[12];
			else if(temp.ref_sym()==4)
				return card_image[13];
			else if(temp.ref_sym()==5)
				return card_image[14];
			else if(temp.ref_sym()==6)
				return card_image[15];
			else if(temp.ref_sym()==7)
				return card_image[16];
			else if(temp.ref_sym()==8)
				return card_image[17];
			else if(temp.ref_sym()==9)
				return card_image[18];
			else if(temp.ref_sym()==0)
				return card_image[19];
			else if(temp.ref_sym()==10)
				return card_image[43];
			else if(temp.ref_sym()==11)
				return card_image[44];
			else if(temp.ref_sym()==12)
				return card_image[45];
		}	
	   else if(temp.ref_col()==2) {
			if(temp.ref_sym()==1)
				return card_image[20];
			else if(temp.ref_sym()==2)
					return card_image[21];
			else if(temp.ref_sym()==3)
				return card_image[22];
			else if(temp.ref_sym()==4)
				return card_image[23];
			else if(temp.ref_sym()==5)
				return card_image[24];
			else if(temp.ref_sym()==6)
				return card_image[25];
			else if(temp.ref_sym()==7)
				return card_image[26];
			else if(temp.ref_sym()==8)
				return card_image[27];
			else if(temp.ref_sym()==9)
				return card_image[28];
			else if(temp.ref_sym()==0)
				return card_image[29];
			else if(temp.ref_sym()==10)
				return card_image[46];
			else if(temp.ref_sym()==11)
				return card_image[47];
			else if(temp.ref_sym()==12)
				return card_image[48];
		}	
	   else if(temp.ref_col()==3) {
			if(temp.ref_sym()==1)
				return card_image[30];
			else if(temp.ref_sym()==2)
				return card_image[31];
			else if(temp.ref_sym()==3)
				return card_image[32];
			else if(temp.ref_sym()==4)
				return card_image[33];
			else if(temp.ref_sym()==5)
				return card_image[34];
			else if(temp.ref_sym()==6)
				return card_image[35];
			else if(temp.ref_sym()==7)
				return card_image[36];
			else if(temp.ref_sym()==8)
				return card_image[37];
			else if(temp.ref_sym()==9)
				return card_image[38];
			else if(temp.ref_sym()==0)
				return card_image[39];
			else if(temp.ref_sym()==10)
				return card_image[49];
			else if(temp.ref_sym()==11)
				return card_image[50];
			else if(temp.ref_sym()==12)
				return card_image[51];
		}	
		else if(temp.ref_sym()==13)
				return card_image[52];
		else if (temp.ref_sym()==14)
				return card_image[53];
		return card_image[52];
	}
	
	public void update_p(){
		set_card(-1);
		
		RadioButton colourOption[]= new RadioButton[4];
		RadioButton challenge[]= new RadioButton[2];
		
		ToggleGroup Choosecolor = new ToggleGroup();
		ToggleGroup ChooseChal = new ToggleGroup();
		
		colourOption[0]= new RadioButton("Red   ");
		colourOption[1]= new RadioButton("Yellow");
		colourOption[2]= new RadioButton("Green ");
		colourOption[3]= new RadioButton("Blue  ");
		colourOption[0].setToggleGroup(Choosecolor);
		colourOption[1].setToggleGroup(Choosecolor);
		colourOption[2].setToggleGroup(Choosecolor);
		colourOption[3].setToggleGroup(Choosecolor);
		
		challenge[0]=new RadioButton("Yes");
		challenge[1]=new RadioButton("No");
		challenge[0].setToggleGroup(ChooseChal);
		challenge[1].setToggleGroup(ChooseChal);
		
		colourOption[0].setVisible(false);
		colourOption[1].setVisible(false);
		colourOption[2].setVisible(false);
		colourOption[3].setVisible(false);
		
		challenge[0].setVisible(false);
		challenge[1].setVisible(false);
		
		colourOption[0].setDisable(true);
		colourOption[1].setDisable(true);
		colourOption[2].setDisable(true);
		colourOption[3].setDisable(true);
		
		challenge[0].setVisible(false);
		challenge[1].setVisible(false);	
		
		
		
		Label colorOp= new Label("Choose Colour:");
		Label challengeChoice = new Label("Challenge?");
		
		colorOp.setVisible(false);
		challengeChoice.setVisible(false);
		
		VBox left=new VBox(10);
		VBox right = new VBox(10);
		left.setAlignment(Pos.CENTER_LEFT);
		right.setAlignment(Pos.CENTER_LEFT);
		left.setPadding(new Insets(10,10,10,10));
		right.setPadding(new Insets(10,10,10,10));
		left.setVisible(true);
		right.setVisible(true);
	    Button sel_col = new Button("Color");
	    sel_col.setVisible(false);
	    Button chal = new Button("Challenge");
	    chal.setVisible(false);
		left.getChildren().addAll(colorOp,colourOption[0],colourOption[1],colourOption[2],colourOption[3],sel_col);
		right.getChildren().addAll(challengeChoice,challenge[0],challenge[1],chal);
		
		Card temp=factory.pile_top();
		ImageView pileTop = setImage(temp);//initialize top of card pile 
		if (factory.pile_top().ref_col()==0)
			pileTop.setStyle("-fx-border-color:red");
		else if (factory.pile_top().ref_col()==1)
			pileTop.setStyle("-fx-border-color:yellow");
		else if (factory.pile_top().ref_col()==2)
			pileTop.setStyle("-fx-border-color:green");
		else if (factory.pile_top().ref_col()==3)
			pileTop.setStyle("-fx-border-color:blue");
		else if (factory.pile_top().ref_col()==4)
			pileTop.setStyle("-fx-border-color:gold");
		else
			pileTop.setStyle("-fx-border-color:white");


	 	StackPane pile = new StackPane();
	 	pile.getChildren().add(pileTop);
	 	pileTop.setFitHeight(150);
	 	pileTop.setFitWidth(100);
	 	HBox handcard = new HBox(10);
		ArrayList<Card>hand=factory.allHand();
		for(int i =0;i<hand.size();i++) {
			ImageView temp1=setImage(hand.get(i));
			temp1.setId(Integer.toString(i));
			temp1.setOnMouseClicked(e->{
				set_card(Integer.parseInt(temp1.getId()));
			});
			temp1.setFitHeight(120);
		 	temp1.setFitWidth(80);
			handcard.getChildren().add(temp1);
		}
		Label playerNo = new Label("Player "+ (factory.cur_player()+1) +"'s turn");
		Button deal = new Button("Deal card");
	    Button draw = new Button("Draw card");
	    Button confirm = new Button("Confirmed");

	    HBox play= new HBox(30);
	    play.getChildren().addAll(draw,deal);
	    play.setAlignment(Pos.CENTER);
		VBox board_C =new VBox();//board center -deck who turn bt
		board_C.getChildren().addAll(handcard,playerNo,play);
		board_C.setAlignment(Pos.CENTER);
		BorderPane board = new BorderPane();
		board.setCenter(pile);
		//board.setTop(null);
		board.setLeft(left);
		board.setRight(right);
		board.setBottom(board_C);
		gamescene = new Scene(board,500,500);
		window.setScene(gamescene);

		confirm.setOnAction(e->{
			if (card_select ==-1)
				return;
			factory.player_deal_card(card_select);
			if (factory.player_win())
			{
				Button restart = new Button("Restart");
				restart.setOnAction(new restart_scene());
				BorderPane End_game = new BorderPane();
				End_game.setTop(new Text("Player " +(factory.cur_player()+1) + " Won the game!!!"));
				End_game.setCenter(restart);
				Scene end = new Scene(End_game);
				window.setScene(end);
			}
			play.getChildren().remove(1);
			play.getChildren().add(deal);
			
			if (factory.pile_top()instanceof Wild){
				sel_col.setVisible(true);
				colorOp.setVisible(true);
				colourOption[0].setVisible(true);
				colourOption[1].setVisible(true);
				colourOption[2].setVisible(true);
				colourOption[3].setVisible(true);
				colourOption[0].setDisable(false);
				colourOption[1].setDisable(false);
				colourOption[2].setDisable(false);
				colourOption[3].setDisable(false);
			}
			else if (factory.pile_top()instanceof WildDrawFour){
				sel_col.setVisible(true);
				colorOp.setVisible(true);
				colourOption[0].setVisible(true);
				colourOption[1].setVisible(true);
				colourOption[2].setVisible(true);
				colourOption[3].setVisible(true);
				colourOption[0].setDisable(false);
				colourOption[1].setDisable(false);
				colourOption[2].setDisable(false);
				colourOption[3].setDisable(false);
			}
			else if (!(factory.pile_top()instanceof NumCard)){
				factory.card_eff(0,0);
				update_p();
			}
			else
			{
				factory.next_player();
				update_p();
			}
		});		
		deal.setOnAction(e->{
			deal_update(handcard);
			play.getChildren().remove(1);
			play.getChildren().add(confirm);
			set_card(-1);
		});
		
		draw.setOnAction(e->{	//done
			factory.draw_card();
			ImageView draws=setImage(factory.drawCard());
			draws.setFitHeight(120);
		 	draws.setFitWidth(80);
			handcard.getChildren().add(draws);

			factory.next_player();
			update_p();
		});
		
		sel_col.setOnAction(e->{
			if (colourOption[0].isSelected())
				color_select = 0;
			else if (colourOption[1].isSelected())
				color_select = 1;
			else if (colourOption[2].isSelected())
				color_select = 2;
			else if (colourOption[3].isSelected())
				color_select = 3;
			else
				return;
			colorOp.setVisible(false);
			colourOption[0].setVisible(false);
			colourOption[1].setVisible(false);
			colourOption[2].setVisible(false);
			colourOption[3].setVisible(false);
			sel_col.setVisible(false);
			if (factory.pile_top()instanceof Wild){
				factory.card_eff(color_select,this.challenge);
				factory.next_player();
				update_p();
			}
			if (factory.pile_top()instanceof WildDrawFour){
				challenge[0].setVisible(true);
				challenge[1].setVisible(true);
				chal.setVisible(true);
				challengeChoice.setVisible(true);
			}
		});
		
		chal.setOnMouseClicked(e->{
			if (challenge[0].isSelected())
				this.challenge =1;
			else if (challenge[1].isSelected())
				this.challenge =2;
			else return;
			factory.card_eff(color_select,this.challenge);
			challenge[0].setVisible(false);
			challenge[1].setVisible(false);
			chal.setVisible(false);
			challengeChoice.setVisible(false);
			factory.next_player();
			update_p();
		});
	}
	
	public void deal_update(HBox handcard){
		ArrayList<Boolean> perm;
		ArrayList<Card> playable=factory.allHand();
		perm = factory.return_available();
		handcard.getChildren().clear();
		for(int i =0;i<playable.size();i++) {
			ImageView temp1=setImage(playable.get(i));
			temp1.setFitHeight(120);
		 	temp1.setFitWidth(80);
		 	temp1.setId(Integer.toString(i));
		 	temp1.setOnMouseClicked(e->{
		 		set_card(Integer.parseInt(temp1.getId()));
		 	});
			if (perm.get(i))
				handcard.getChildren().add(temp1);	
		}
	}
	
	public void set_card(int num){
		card_select = num;
	}
	
	class update implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			 update_p();
		}
	}
	
	class restart_scene implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			window.setScene(scene1);
		}
		
	}
	
	public static void main(String[] args) {
		launch(args); 	
	}
}

