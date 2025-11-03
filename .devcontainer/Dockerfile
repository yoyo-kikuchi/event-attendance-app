FROM amazoncorretto:21-al2023-jdk

ARG USERNAME=java

RUN dnf -y update \
    && dnf -y install maven shadow-utils sudo git ca-certificates \
    && dnf clean all \
    && update-ca-trust \
    && adduser ${USERNAME} \
    && echo "${USERNAME} ALL=(ALL) NOPASSWD: ALL" > /etc/sudoers.d/${USERNAME} \
    && chmod 0440 /etc/sudoers.d/${USERNAME} \
    && echo 'export PS1="\[\033[01;32m\]\u@\h\[\033[00m\]:\[\033[01;34m\]\w\[\033[00m\]\$ "' >> /etc/profile

ENV JAVA_HOME=/usr/lib/jvm/java-21-amazon-corretto.x86_64 \
    PATH=$JAVA_HOME/bin:$PATH

USER ${USERNAME}

EXPOSE 8080
