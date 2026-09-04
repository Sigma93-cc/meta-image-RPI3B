SUMMARY = "my-image recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

require recipes-core/images/core-image-minimal.bb

IMAGE_CLASSES += "extrausers"
IMAGE_BOOT_FILES:append = " waveshare35b-v2.dtbo;overlays/waveshare35b-v2.dtbo"

IMAGE_INSTALL:append = " \
    kernel-module-ads7846 \
    qtbase \
    qtbase-plugins \
    systemanalyzer \
    qtfbsettings \
    swupdate \
    swupdate-www \
    swupdate-hwrevision \
    libubootenv-bin \
    u-boot \   
    udevrules \
    psplash-sigmastudio \
    ttf-dejavu-sans \
"

IMAGE_FEATURES:append = " \
    read-only-rootfs \
    ssh-server-openssh \
    splash \
"

PACKAGE_EXCLUDE = " \
    udev-hwdb \
" 

IMAGE_FSTYPES:append = " wic ext4.gz"
IMAGE_FSTYPES:remove = "ext3"
WKS_FILE = "image.wks"

ROOTFS_POSTPROCESS_COMMAND += "\
    add_custom_fstab \
    create_log_simlynk \
    ${@bb.utils.contains("IMAGE_FEATURES", "debug-tweaks", "drop_ssh_hardening ", "", d)} \
"

drop_ssh_hardening() {
    rm -f ${IMAGE_ROOTFS}/etc/ssh/sshd_config.d/20-hardening.conf
}

create_log_simlynk() {
    ln -sfn /data/log ${IMAGE_ROOTFS}/var/log
}

add_custom_fstab() {
    install -d ${IMAGE_ROOTFS}/data    
    cat >> ${IMAGE_ROOTFS}/etc/fstab <<EOF
/dev/mmcblk0p1   /boot   vfat    defaults    0  2
/dev/mmcblk0p4   /data   ext4    defaults    0  2
EOF
}

TOOLCHAIN_HOST_TASK:append = " \
     nativesdk-packagegroup-qt5-toolchain-host \   
"
TOOLCHAIN_TARGET_TASK:append= " \
    qtbase-dev \ 
    qtbase-mkspecs \
    spdlog-dev \
    libubootenv-dev \
    fmt-dev \
"