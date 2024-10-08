using ClinicServiceNamespace;

namespace ClinicDesktop
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            //Button button = new Button();
            //button.Text = "OK";
            //button.Left = 50;
            //button.Top = 50;
            //this.Controls.Add(button);
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            ClinicClient clinicClient = new ClinicClient("http://localhost:5192/", new HttpClient());
            ICollection<Client> clients = clinicClient.ClientGetAllAsync().Result;

            listViewClients.Items.Clear();

            foreach (Client client in clients)
            {
                ListViewItem item = new ListViewItem();
                item.Text = client.ClientId.ToString();
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.SurName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.FirstName
                });
                item.SubItems.Add(new ListViewItem.ListViewSubItem()
                {
                    Text = client.Patronymic
                });
                listViewClients.Items.Add(item);
            }
        }
    }

    //public partial class Sample
    //{
    //    public int a;
    //}
}
