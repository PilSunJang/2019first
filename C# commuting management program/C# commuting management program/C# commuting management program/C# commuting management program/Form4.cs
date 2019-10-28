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
using System.Data.OleDb;
using System.Data.Odbc;

namespace 출퇴근_관리
{
    public partial class Form4 : Form
    {
        MySqlConnection con = new MySqlConnection("Server=localhost;Database=login;Uid=root;Pwd=1234;");
        MySqlCommand cmd = new MySqlCommand();
        MySqlDataReader dr;

        int nBetweenDayCnt = 0;
        public Form4()
        {
            InitializeComponent();
            pictureBox1.Load(@"D:\c#\image\c1.png");
            pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;
        }

        private void Form4_Load(object sender, EventArgs e)
        {
            cmd.Connection = con;
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            nBetweenDayCnt = 0;

            int i = 0;
            DateTime temp;
            while (true)
            {
                temp = hustart.Value.Date.AddDays(i);

                if (temp.DayOfWeek != DayOfWeek.Sunday && temp.DayOfWeek != DayOfWeek.Saturday)
                    nBetweenDayCnt++;

                TimeSpan Between = huend.Value.Date - temp;
                if (Between.Days <= 0)
                {
                    break;
                }

                temp = hustart.Value.Date.AddDays(i);
                i++;
            }

            textBox1.Text = nBetweenDayCnt.ToString();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            String str = "SERVER = localhost; DATABASE = login; UID = root; PWD = 1234; ";
            String query = "UPDATE login SET hustart = '" + hustart.Text + "', huend = '" + huend.Text + "' WHERE name = '" + textBox2.Text + "'";
            MySqlConnection con = new MySqlConnection(str);
            MySqlCommand cmd = new MySqlCommand(query, con);
            MySqlDataReader dbr;
            try
            {
                con.Open();
                dbr = cmd.ExecuteReader();
                MessageBox.Show("휴가신청 완료");
                while (dbr.Read())
                {

                }
            }
            catch (Exception es)
            {
                MessageBox.Show(es.Message);
            }
            con.Close();

            /**string constring = "datasource=localhost;port=3306;username=root;Password=1234;";
            MySqlCommand comm = new MySqlCommand();
            comm.CommandText = "insert into tblFull (name, position, department, userid, passwd, hustart, huend) values('" + "','" + "','" + "','" + "','" + "','" + this.hustart + "','" + this.huend + "')";
            MySqlConnection condateBase = new MySqlConnection(constring);
            MySqlCommand cmdDataBase = new MySqlCommand(Query, condateBase);
            MySqlDataReader myReader;
            try
            {
                condateBase.Open();
                myReader = cmdDataBase.ExecuteReader();
                MessageBox.Show("Saved");
                while (myReader.Read())
                {

                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }*/
            
                       
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            this.DialogResult = DialogResult.Cancel;
        }
    }
    
}
