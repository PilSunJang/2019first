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
using MySql.Data;

namespace 출퇴근_관리
{
    public partial class Form2 : Form
    {
        MySqlConnection con = new MySqlConnection("SERVER = localhost; DATABASE = login; UID = root; PWD = 1234;");
        //                                                  서버 명                디비 명     아이디      비밀번호
        ListViewItem lvwitem;

        public Form2()
        {
            InitializeComponent();

            pictureBox1.Load(@"D:\c#\image\c1.png");
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
            

        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            
            con.Open();
            MySqlCommand sqlcmd = new MySqlCommand("SELECT name, position, department, userid FROM login", con);
            MySqlDataReader sqldr = sqlcmd.ExecuteReader();
            while (sqldr.Read() == true)
            { 
                if(sqldr["userid"].ToString() == textUsername.Text)
                {
                    this.DialogResult = DialogResult.OK;
                    Form1.userrealname = "" + sqldr["name"].ToString() + ""; // 이름
                    Form1.username = "" + sqldr["name"].ToString() + "";     // 이름
                    Form1.position = "" + sqldr["position"].ToString() + ""; // 직급
                    Form1.department = "" + sqldr["department"].ToString() + ""; // 부서

                }
                //textBox1.Text = sqldr[0].ToString();
               // this.DialogResult = DialogResult.OK;
              //  Form1.userrealname = "" + sqldr;
                /** 
                 * textBox1.Text = "" + sqldr;
                 * lvwitem.SubItems.Add(sqldr[1].ToString());
                 lvwitem.SubItems.Add(sqldr[2].ToString());         
                 lvwitem.SubItems.Add(sqldr[3].ToString());
                 lvwitem.SubItems.Add(sqldr[4].ToString());
                 listView1.Items.Add(lvwitem);*/
            }
            con.Close();



            
            // DB 에서 회원 ID.Passwd 불러오기
            
            con.Open();
            string userid = textUsername.Text;
            string password = textPassword.Text;
            MySqlCommand cmd = new MySqlCommand("select userid, passwd from login where userid='" + textUsername.Text + "'and passwd='" + textPassword.Text + "'", con);
            

            


            MySqlDataAdapter da = new MySqlDataAdapter(cmd);
            DataTable dt = new DataTable();
            da.Fill(dt);           
            if (dt.Rows.Count > 0)
            {
                MessageBox.Show("로그인 성공");
                //this.DialogResult = DialogResult.OK;
                //Form1.username = "" + textUsername;
                
                
            }
            else
            {
                MessageBox.Show("로그인 실패");
                //this.DialogResult = DialogResult.Cancel;
                // Form1.username = "";
            }
            
            
            con.Close();
            #region

            /*
             * 
            con.Open();
            cmd.Connection = con;
            MySqlDataAdapter adapter = new MySqlDataAdapter();
            try
            {
                cmd.CommandText = "select count(*) from login where name = '" + textUsername.Text + "and age'" + textPassword.Text + "'";
                int valor = int.Parse(cmd.ExecuteScalar().ToString());
                if (valor == 1)
                {
                    this.DialogResult = DialogResult.OK;
                    Form1.username = "" + textUsername;
                    Form1 f1 = new Form1();
                    f1.Show();
                    this.Hide();

                }
                else
                {
                    this.DialogResult = DialogResult.Cancel;
                    Form1.username = "";
                }
            }
            catch (Exception ex)
            {
                label3.Text = "error" + ex;
            }
            con.Close();
            */
            #endregion
    

        }
        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
            Form1.username = "";
        }

        private void textPassword_KeyDown(object sender, KeyEventArgs e)
        {

        }

        private void btsignup_Click(object sender, EventArgs e)
        {
            //this.Hide();
            Form3 f3 = new Form3();
            f3.ShowDialog();
        }

        private void textUsername_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }
    }
}
