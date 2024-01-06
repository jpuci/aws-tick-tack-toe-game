sudo yum update -y

# install docker
sudo yum install docker -y
sudo systemctl enable docker
sudo usermod -a -G docker ec2-user
sudo systemctl start docker
sudo chmod 666 /var/run/docker.sock

# install docker-compose
# https://docs.docker.com/compose/install/linux/#install-the-plugin-manually
DOCKER_CONFIG=${DOCKER_CONFIG:-$HOME/.docker}
mkdir -p $DOCKER_CONFIG/cli-plugins
curl -SL https://github.com/docker/compose/releases/download/v2.23.3/docker-compose-linux-x86_64 -o $DOCKER_CONFIG/cli-plugins/docker-compose
chmod +x $DOCKER_CONFIG/cli-plugins/docker-compose
