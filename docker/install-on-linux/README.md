OS - PRETTY_NAME="Debian GNU/Linux 12 (bookworm)"
-----


## Install docker as root
`sudo apt update`

`sudo apt-get install ca-certificates curl gnupg`

`sudo install -m 0755 -d /etc/apt/keyrings`

`curl -fsSL https://download.docker.com/linux/debian/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg`
`sudo chmod a+r /etc/apt/keyrings/docker.gpg`

`echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/debian \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null`

`sudo apt-get update`

`sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin`

### Start docker service
`sudo systemctl start docker`

`sudo systemctl enable docker`

### Create non-root user to run docker commonds

Check if docker group exist 

`cat /etc/group | grep docker`

Create & add user to docker group

`adduser user_name`

`sudo usermod -aG docker user_name`

Switch user 

`su user_name`

Check groups user belongs to: `id`

Now this user should have access to run docker commands
`docker ps`


## Install chrome
`wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb`

`sudo apt install ./google-chrome-stable_current_amd64.deb -y`


## Install Remote desktop
`sudo apt update && sudo apt upgrade -y`

`sudo apt install xfce4 xfce4-goodies xorg dbus-x11 x11-xserver-utils -y`

`sudo apt install xrdp -y`

`sudo systemctl status xrdp`

`sudo adduser xrdp ssl-cert`

`sudo systemctl restart xrdp`


change password of user `xrdp` to login from RD

`sudo -s` 

`passwd root`

Test - login via external IP
`xrdp/newly_set_password`






