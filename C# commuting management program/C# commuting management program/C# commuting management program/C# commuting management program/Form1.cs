
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace 출퇴근_관리
{
    public partial class Form1 : Form
    {
        MySqlConnection sqlconn = new MySqlConnection("SERVER = localhost; DATABASE = login; UID = root; PWD = 1234;");
        //                                                      서버 명                디비 명     아이디      비밀번호
        ListViewItem lvwitem;
        
        public static String username, userrealname, position, department;

        public Form1()
        {

            InitializeComponent();

            pictureBox1.Load(@"D:\c#\image\c1.png");
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
        }

        private void btnLogin_Click(object sender, EventArgs e)     // 로그인 버튼
        {


            ListViewItem lvt = new ListViewItem();
            ListViewItem lvt2 = new ListViewItem();
            ListViewItem lvt3 = new ListViewItem();
            /**--------- 06.20 -------------------------------------------------------------
            ListViewItem lvt = new ListViewItem();
            MySqlConnection con = new MySqlConnection("Server=localhost;Database=login;Uid=root;Pwd=1234;");
            con.Open();
            MySqlCommand cmd = new MySqlCommand("select * from login", con);
            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);
            //-----------------------------------------------------------------------------*/
            Form2 f = new Form2();
            if (btnLogin.Text == "Login")
            {
                if (f.ShowDialog() == DialogResult.OK)
                {
                    textBox1.Text = username + "님 반갑습니다.";
                    textBox2.Text = userrealname;
                    lvt.Text = "이름 : " + textBox2.Text;
                    lvt.SubItems.Add(textBox2.Text);
                    listView3.Items.Add(lvt);
                    lvt2.Text = "부서 : " + department;
                    lvt2.SubItems.Add(lvt2.Text);
                    listView3.Items.Add(lvt2);
                    lvt3.Text = "직급 : " + position;
                    lvt3.SubItems.Add(lvt3.Text);
                    listView3.Items.Add(lvt3);

                    btnLogin.Text = "Logout";
                }
                else
                {
                    textBox1.Text = "로그인에 실패했습니다.";
                }
                f.Dispose();
            }
            else
            {
                textBox1.Text = "안녕히가세요.";
                btnLogin.Text = "Login";
            }
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            // 종료 버튼
            Application.Exit();
        }

        private void Form1_Load(object sender, EventArgs e)
        {


            this.Font = new Font("Gullim", 15.0F);

        }

        private void button1_Click(object sender, EventArgs e)
        {
            // 출근 버튼
            // 수정 DB
            ListViewItem lvt = new ListViewItem();
            textBox1.Text = DateTime.Now.ToString();
            lvt.Text = textBox1.Text;
            lvt.SubItems.Add(textBox1.Text);            
            listView1.Items.Add(lvt);
            MySqlCommand sqlcmd = new MySqlCommand("UPDATE login SET homein = '" + textBox1.Text + "' WHERE name = '" + textBox2.Text + "'", sqlconn);
            MySqlDataReader dbr1;
            try
            {
                sqlconn.Open();
                dbr1 = sqlcmd.ExecuteReader();
                MessageBox.Show("어서옵쇼!");
                while (dbr1.Read())
                {

                }
            }
            catch (Exception es)
            {
                MessageBox.Show(es.Message);
            }
            sqlconn.Close();
            textBox1.Text = "";
          
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            // 퇴근 버튼
            ListViewItem lvt = new ListViewItem();
            textBox1.Text = DateTime.Now.ToString();
            lvt.Text = textBox1.Text;
            lvt.SubItems.Add(textBox1.Text);
            listView2.Items.Add(lvt);
            

            
            MySqlCommand sqlcmd = new MySqlCommand("UPDATE login SET homeout = '" + textBox1.Text + "' WHERE name = '" + textBox2.Text + "'", sqlconn);           
            MySqlDataReader dbr1;
            try
            {
                sqlconn.Open();
                dbr1 = sqlcmd.ExecuteReader();
                MessageBox.Show("이제 집으로 갓!");
                while (dbr1.Read())
                {

                }
            }
            catch (Exception es)
            {
                MessageBox.Show(es.Message);
            }
            sqlconn.Close();
            textBox1.Text = "";           
        }
        
        private void button3_Click(object sender, EventArgs e)
        {
           
            /**
            // 삭제 버튼
            if (MessageBox.Show("선택하신 항목이 삭제 됩니다.\r계속 하시겠습니까?", "항목 삭제", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                if (listView1.SelectedItems.Count > 0)
                {
                    int index = listView1.FocusedItem.Index;
                    listView1.Items.RemoveAt(index);
                }
                if (listView2.SelectedItems.Count > 0)
                {
                    int index = listView2.FocusedItem.Index;
                    listView2.Items.RemoveAt(index);
                }                                
            }*/
            
        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // 값이 설정되어 있는 칸이 아닌 다른 칸 클릭 시 수정, 삭제 비활성화
            bool selected = listView1.SelectedItems.Count > 0;
            //button3.Enabled = button4.Enabled = selected;
        }

       /** private void button4_Click(object sender, EventArgs e)
        {
            // 수정 버튼

            
            
            if (listView1.SelectedIndices.Count > 0)
            {
                sqlconn.Open();
                listView1.SelectedItems[0].SubItems[0].Text = textBox1.Text;
                MySqlCommand sqlcmd = new MySqlCommand("UPDATE login SET homein = '" + textBox1.Text + "' WHERE name = '" + textBox2.Text + "'", sqlconn);
                sqlcmd.Connection = sqlconn;
                sqlcmd.ExecuteNonQuery();
                sqlconn.Close();

            }
            else if(listView2.SelectedIndices.Count > 0)
            {
                sqlconn.Open();
                listView2.SelectedItems[0].SubItems[0].Text = textBox1.Text;               
                MySqlCommand sqlcmd = new MySqlCommand("UPDATE login SET homeout = '" + textBox1.Text + "' WHERE name = '" + textBox2.Text + "'", sqlconn);
                sqlcmd.Connection = sqlconn;
                sqlcmd.ExecuteNonQuery();
                sqlconn.Close();
            }

        }*/

        private void button5_Click(object sender, EventArgs e)
        { 
            // 휴가 신청
            Form4 f4 = new Form4();
            f4.ShowDialog();
        }

        
    }
}
